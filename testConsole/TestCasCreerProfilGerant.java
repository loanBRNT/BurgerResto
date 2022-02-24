import controleur.ControlCreerProfil;
import vueconsole.BoundaryCreerProfilGerant;

public class TestCasCreerProfilGerant {

    public static void main(String[] args) {
        // Initialisation controleur du cas
        ControlCreerProfil controlCreerProfil = new ControlCreerProfil();
        // Initialisation vue du cas
        BoundaryCreerProfilGerant boundaryCreerProfilGerant =
                new BoundaryCreerProfilGerant(controlCreerProfil);

        // Lancement du cas
        boundaryCreerProfilGerant.creerProfilGerant();

        // Verification de la bonne realisation du cas
        System.out.println("VERIFICATION");
        System.out.println(controlCreerProfil.visualiserBDUtilisateur());

        // Resultat du test
        // Veuillez entrer votre nom
        // Victor
        // Veuillez entrer votre prenom
        // Martin
        // Veuillez entrer votre mot de passe
        // gmv
        // VERIFICATION
        // BDPersonnel [listePersonnel={0=Personnel [gerant=true, nom=Victor,
        // prenom=Martin, login=Martin.Victor, mdp=gmv, connecte=false]}]
        // BDClient [listeClient={}]
    }
}