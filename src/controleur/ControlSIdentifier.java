package controleur;

import modele.BDClient;
import modele.BDPersonnel;
import modele.ProfilUtilisateur;

public class ControlSIdentifier {

    //Attributs
    private BDClient bdClient = BDClient.getInstance();
    private BDPersonnel bdPersonnel = BDPersonnel.getInstance();

    //methodes
    public int sIdentifier(ProfilUtilisateur profilUtilisateur, String login, String mdp){
        int num;
        switch (profilUtilisateur){
            case CLIENT:
                num = bdClient.connexionClient(login, mdp);
                break;

            default:
                num = bdPersonnel.connexionPersonnel(login, mdp);
                break;
        }
        return num;
    }

    public String visualiserBDUtilisateur() {
        return (bdPersonnel + "\n" + bdClient);
    }
}
