package vueconsole;

import controleur.ControlCreerProfil;
import modele.ProfilUtilisateur;

public class BoundaryCreerProfilGerant {

    //attributs
    private ControlCreerProfil controlCreerProfil;

    //constructeur
    public BoundaryCreerProfilGerant(ControlCreerProfil c){
        controlCreerProfil = c;
    }


    //methodes

    public void creerProfilGerant() {

        System.out.println("Veuillez entrez votre nom");
        String nom = Clavier.entrerClavierString();
        System.out.println("Veuillez entrez votre prénom");
        String prenom = Clavier.entrerClavierString();
        System.out.println("Veuillez entrez votre mdp");
        String mdp = Clavier.entrerClavierString();

        controlCreerProfil.creerProfil(ProfilUtilisateur.GERANT,nom,prenom,mdp);
    }
}
