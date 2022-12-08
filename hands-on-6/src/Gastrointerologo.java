import net.sf.clipsrules.jni.Environment;

public class Gastrointerologo extends Doctor {
    @Override
    protected void setup() {
        clip_rules_file = "diagnostic/gastroenterologia.clp";
        saludo = ": Hola, mucho gusto ¿Viene a consulta?";
        mensaje_recibido = ": Así que usted tiene todo eso...";
        despedida = ": ¿Listo para comenzar tu tratamiento?";
        disculpa = ": Le ofresco una disculpla, esa no es mi área. Si gustas te agendo una cita con un amigo especialista en eso.";
        al_diagnosticar = ": Padeces de ";

        super.setup();
    }
}
