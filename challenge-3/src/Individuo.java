
import jade.core.AID;
import jade.core.Agent;
import net.sf.clipsrules.jni.*;
import jade.core.behaviours.*;
import jade.lang.acl.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Individuo extends Agent {
    protected Environment clips;
    protected String clip_rules_file;
    protected List<String> my_facts = new ArrayList<>();

    @Override
    protected void setup() {
        clips = new Environment();

        addBehaviour(new Diagnosticar());

        try {
            clips.clear();
            clips.eval("(load \"" + clip_rules_file + "\")");
            clips.reset();
        } catch (CLIPSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

        System.out.println(getLocalName() + " listo.");
    }

    private class Diagnosticar extends CyclicBehaviour {
        public void action() {
            try {
                // Obtiene el primer mensaje de la cola de mensajes
                ACLMessage mensaje = receive();

                if (mensaje != null) {
                    String paciente_nombre = String.format("%-16s", mensaje.getSender().getLocalName().toString());
                    String doctor_nombre = String.format("%-16s", getLocalName());
                    String doctor_paciente = String.format(doctor_nombre + "<- " + paciente_nombre);

                    clips.eval("(assert (msg \"" + doctor_nombre + "\"))");
                    //System.out.println(doctor_paciente + "(assert (" + mensaje.getContent() + "))");
                    clips.eval("(assert (" + mensaje.getContent() + "))");

                    Random rnd = new Random();
                    Thread.sleep(rnd.nextInt(1, 2) * 1000);

                    clips.run();

                    List<FactInstance> facts = clips.getFactList();

                    if (!facts.isEmpty()) {
                        for (FactInstance fact : facts) {
                            for (SlotValue slot : fact.getSlotValues()) {
                                String s = slot.getSlotValue().toString();
                                s = fact.getRelationName() + " " + s.substring(1, s.length() - 1);

                                if (!s.contains("paciente") || my_facts.contains(s))
                                    continue;

                                //System.out.println(doctor_nombre + ": Guardando " + s);
                                my_facts.add(s);
                                
                                if (getLocalName() != "Anestesiologo")
                                    addBehaviour(new EnviarMensaje("Anestesiologo", s));
                                if (getLocalName() != "Cardiologo")
                                    addBehaviour(new EnviarMensaje("Cardiologo", s));
                                if (getLocalName() != "Cirujano")
                                    addBehaviour(new EnviarMensaje("Cirujano", s));
                                if (getLocalName() != "Enfermera")
                                    addBehaviour(new EnviarMensaje("Enfermera", s));
                            }
                        }
                    }

                    

                    
                }
            } catch (CLIPSException | InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

    protected class EnviarMensaje extends OneShotBehaviour {
        String doctor_nombre;
        String accion;

        EnviarMensaje(String doc_nombre, String accion) {
            this.doctor_nombre = doc_nombre;
            this.accion = accion;
        }

        public void action() {
            AID id = new AID();
            id.setLocalName(doctor_nombre);
            ACLMessage mensaje = new ACLMessage(ACLMessage.INFORM);

            // Rellenar los campos necesarios del mensaje
            mensaje.setSender(getAID());
            mensaje.setLanguage("English");
            mensaje.addReceiver(id);
            
            // Envia el mensaje a los destinatarios
            mensaje.setContent(accion);
            send(mensaje);
        }
    }
}