package vueconsole;

import controleur.ControlCommander;

public class BoundaryCommander {

    private ControlCommander controlCommander;
    private BoundaryEnregistrerDonneBanquaire boundaryEnregistrerDonneBanquaire;

    public BoundaryCommander(ControlCommander c, BoundaryEnregistrerDonneBanquaire b){
        controlCommander = c;
        boundaryEnregistrerDonneBanquaire = b;
    }

    public void commander(){

    }

}
