import net.sf.clipsrules.jni.Environment;

public class Cardiologo extends Individuo {
    @Override
    protected void setup() {
        clip_rules_file = "procedure/cardiologo.clp";

        super.setup();
    }
}