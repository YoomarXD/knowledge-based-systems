import net.sf.clipsrules.jni.Environment;

public class Cirujano extends Individuo {
    @Override
    protected void setup() {
        clip_rules_file = "procedure/cirujano.clp";

        super.setup();
    }
}