
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SimpleBehaviour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import jade.core.*;
import jade.lang.acl.ACLMessage;

public class Paciente extends Individuo {
    @Override
    protected void setup() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        addBehaviour(new EnviarMensaje("Anestesiologo", "estoy listo"));

        System.out.println(getLocalName() + " listo.");
    }   
}
