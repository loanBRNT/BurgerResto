package vueconsole;

import controleur.ControlSIdentifier;
import modele.ProfilUtilisateur;

public class BoundarySIdentifierPersonnel {
    private ControlSIdentifier controlSIdentifier;

    public BoundarySIdentifierPersonnel(ControlSIdentifier c){
        controlSIdentifier = c;
    }

    //methodes
    public int sIdentifierPersonnel(){

        System.out.println("Veuillez entrez votre login");
        String login = Clavier.entrerClavierString();
        System.out.println("Veuillez entrez votre mdp");
        String mdp = Clavier.entrerClavierString();

        controlSIdentifier.sIdentifier(ProfilUtilisateur.PERSONNEL,login,mdp);

        return 0;
    }

}
