package vueconsole;

import controleur.ControlCommander;

public class BoundaryCommander {

    private ControlCommander controlCommander;
    private BoundaryEnregistrerCoordonneesBancaires boundaryEnregistrerDonneBanquaire;

    public BoundaryCommander(ControlCommander c, BoundaryEnregistrerCoordonneesBancaires b){
        controlCommander = c;
        boundaryEnregistrerDonneBanquaire = b;
    }

    public void commander(int numClient){

    }

    private int selectionnerBurger(){

        return 0;
    }

    private int selectionnerAccompagnement(){

        return 0;
    }

    private int selectionnerBoisson(){

        return 0;
    }

}
