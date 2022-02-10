package vueconsole;

import controleur.ControlCreerProfil;
import modele.ProfilUtilisateur;

public class BoundaryCreerProfilClient {

    //attributs
    private ControlCreerProfil controlCreerProfil;

    //constructeur
    public BoundaryCreerProfilClient(ControlCreerProfil c){
        controlCreerProfil = c;
    }


    //methodes

    public void creerProfilClient() {

        System.out.println("Veuillez entrez votre nom");
        String nom = Clavier.entrerClavierString();
        System.out.println("Veuillez entrez votre prénom");
        String prenom = Clavier.entrerClavierString();
        System.out.println("Veuillez entrez votre mdp");
        String mdp = Clavier.entrerClavierString();

        controlCreerProfil.creerProfil(ProfilUtilisateur.CLIENT,nom,prenom,mdp);
    }
}
