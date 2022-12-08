
import jade.core.Agent;
import net.sf.clipsrules.jni.*;
import jade.core.behaviours.*;
import jade.lang.acl.*;
import java.util.Arrays;
import java.util.List;

public class Doctor extends Agent {
    protected Environment clips;
    protected String clip_rules_file;
    protected String saludo;
    protected String mensaje_recibido;
    protected String despedida;
    protected String disculpa;
    protected String al_diagnosticar;

    @Override
    protected void setup() {
        clips = new Environment();

        addBehaviour(new Diagnosticar());

        System.out.println(getLocalName() + saludo);
    }

    private class Diagnosticar extends CyclicBehaviour {
        public void action() {
            try {
                // Obtiene el primer mensaje de la cola de mensajes
                ACLMessage mensaje = receive();

                if (mensaje != null) {
                    clips.clear();
                    clips.eval("(load \"" + clip_rules_file + "\")");
                    clips.reset();

                    String paciente_nombre = String.format("%-16s", mensaje.getSender().getLocalName().toString());
                    String doctor_nombre = String.format("%-16s", getLocalName());
                    
                    clips.eval("(assert (paciente " + paciente_nombre + "))");

                    List<String> sintomas = Arrays.asList(mensaje.getContent().split("\\s+"));
                    System.out.println("\n" + doctor_nombre + " -> " + paciente_nombre + mensaje_recibido + "(" + sintomas.size() + ")");
                    for (String sintoma : sintomas) {
                        clips.eval("(assert (sintoma " + sintoma + "))");
                    }
                    clips.run();
                    
                    Boolean any_diagnostic = false;
                    List<FactInstance> facts = clips.getFactList();
                    for (FactInstance fact : facts) {
                        for (SlotValue slot : fact.getSlotValues()) {
                            String s = slot.getSlotValue().toString();
                            s = s.substring(1, s.length() - 1);

                            if (s.startsWith("n-")) {
                                System.out.println("\n" + doctor_nombre + " -> " + paciente_nombre + al_diagnosticar + s.substring(2));
                                any_diagnostic = true;
                            }
                        }
                    }

                    if (any_diagnostic) {
                        System.out.println("\n" + doctor_nombre + " -> " + paciente_nombre + despedida);
                    } else {
                        System.out.println("\n" + doctor_nombre + " -> " + paciente_nombre + disculpa);
                    }
                }
            } catch (CLIPSException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}