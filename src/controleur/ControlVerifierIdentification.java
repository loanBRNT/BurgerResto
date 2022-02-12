package controleur;

import modele.*;

public class ControlVerifierIdentification {

    //ATTRIBUTS
    private BDClient bdClient = BDClient.getInstance();
    private BDPersonnel bdPersonnel = BDPersonnel.getInstance();

    //METHODES
    public boolean verifierIdentification(ProfilUtilisateur profilUtilisateur, int numProfil) {
        boolean connexionOK = false;
        Personnel personnel;
        switch (profilUtilisateur) {
            case CLIENT:
                Client client = bdClient.trouverClient(numProfil);
                if (client != null) connexionOK = client.isConnecte();
                break;

            case PERSONNEL:
                personnel = bdPersonnel.trouverPersonnel(numProfil);
                if (personnel != null) connexionOK = personnel.isConnecte();
                break;

            default:
                personnel = bdPersonnel.trouverPersonnel(numProfil);
                if (personnel != null) {
                    if (personnel.isGerant()){
                        connexionOK = personnel.isConnecte();
                    }
                }
                break;
        }
        return connexionOK;
    }
}
