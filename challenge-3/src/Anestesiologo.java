import net.sf.clipsrules.jni.Environment;

public class Anestesiologo extends Individuo {
    @Override
    protected void setup() {
        clip_rules_file = "procedure/anestesiologo.clp";

        super.setup();
    }
}