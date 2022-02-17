package controleur;

import modele.BDClient;
import modele.Client;

public class ControlEnregistrerCoordonneesBancaires {

    private ControlVerifierCoordonneesBancaires controlVerifierCoordonneesBancaires;
    private BDClient bdClient = BDClient.getInstance();

    public ControlEnregistrerCoordonneesBancaires(ControlVerifierCoordonneesBancaires c) {
        controlVerifierCoordonneesBancaires = c;
    }

    public boolean enregistrerCoordonneesBancaires(int numeroClient, int numeroCarte, int dateCarte){
        boolean carteValide = controlVerifierCoordonneesBancaires.verifierCoordonnesBancaires(numeroCarte,dateCarte);
        if (carteValide){
            Client client = bdClient.trouverClient(numeroClient);
            if (client != null) client.enregistrerCoordonnesBancaires(numeroCarte,dateCarte);
        }
        return carteValide;
    }
}
