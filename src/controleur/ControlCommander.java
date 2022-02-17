package controleur;

import modele.Menu;

import java.util.List;

public class ControlCommander {

    private ControlVerifierIdentification controlVerifierIdentification;
    private Menu menu = Menu.getInstance();

    public ControlCommander(ControlVerifierIdentification c){
        controlVerifierIdentification = c;
    }

    public void verifierIdentification(int numclient){

    }

    public List<String> donnerListeHamburger(){

    }

    public List<String> donnerListeAccompagnement(){

    }

    public List<String> donnerListeBoisson(){

    }

    public boolean verifierExistenceCarteBancaire(int numClient){

        return false;
    }

    public int enregistrerCommande(int numClient, int numeroHambirger, int numeroBoisson){


        return 0;
    }
}
