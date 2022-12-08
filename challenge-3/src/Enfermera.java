import net.sf.clipsrules.jni.Environment;

public class Enfermera extends Individuo {
    @Override
    protected void setup() {
        clip_rules_file = "procedure/enfermera.clp";

        super.setup();
    }
}