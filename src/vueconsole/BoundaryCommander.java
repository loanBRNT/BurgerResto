package vueconsole;

import controleur.ControlCommander;

public class BoundaryCommander {

    private ControlCommander controlCommander;
    private BoundaryEnregistrerCoordonneesBancaires boundaryEnregistrerDonneBanquaire;

    public BoundaryCommander(ControlCommander c, BoundaryEnregistrerCoordonneesBancaires b){
        controlCommander = c;
        boundaryEnregistrerDonneBanquaire = b;
    }

    public void commander(){

    }

}
