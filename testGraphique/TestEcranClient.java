import controleur.ControlAjouterAlimentMenu;
import controleur.ControlCommander;
import controleur.ControlCreerProfil;
import controleur.ControlEnregistrerCoordonneesBancaires;
import controleur.ControlSIdentifier;
import controleur.ControlVerifierCoordonneesBancaires;
import controleur.ControlVerifierIdentification;
import modele.AlimentMenu;
import modele.ProfilUtilisateur;
import vueGraphique.FrameClient;

public class TestEcranClient {

    public static void main(String[] args) {
        // initialisation pour test commander
        ControlCreerProfil controlCreerProfil = new ControlCreerProfil();
        ControlVerifierIdentification controlVerifierIdentification = new ControlVerifierIdentification();
        ControlAjouterAlimentMenu controlAjouterAlimentCarte = new ControlAjouterAlimentMenu(controlVerifierIdentification);
        ControlSIdentifier controlSIdentifier = new ControlSIdentifier();

        // senario pour le test
        controlAjouterAlimentCarte.ajouterAliment(AlimentMenu.HAMBURGER,
                "baconBurger");
        controlAjouterAlimentCarte.ajouterAliment(AlimentMenu.HAMBURGER,
                "chickenBurger");
        controlAjouterAlimentCarte.ajouterAliment(AlimentMenu.HAMBURGER,
                "cheeseBurger");
        controlAjouterAlimentCarte.ajouterAliment(AlimentMenu.ACCOMPAGNEMENT,
                "frites");
        controlAjouterAlimentCarte.ajouterAliment(AlimentMenu.ACCOMPAGNEMENT,
                "pommesChips");
        controlAjouterAlimentCarte.ajouterAliment(AlimentMenu.BOISSON, "coca");
        controlAjouterAlimentCarte.ajouterAliment(AlimentMenu.BOISSON,
                "orangeBulles");

        controlCreerProfil.creerProfil(ProfilUtilisateur.CLIENT, "Dupond",
                "Hector", "cdh");
        int numClient = controlSIdentifier.sIdentifier(
                ProfilUtilisateur.CLIENT, "Hector.Dupond", "cdh");

        controlCreerProfil.creerProfil(ProfilUtilisateur.CLIENT, "Durand",
                "Jacques", "cdj");
        int numClient2 = controlSIdentifier.sIdentifier(
                ProfilUtilisateur.CLIENT, "Jacques.Durand", "cdj");

        // cas commander
        ControlVerifierCoordonneesBancaires controlVerifierCoordonneesBancaires = new ControlVerifierCoordonneesBancaires();
        ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires = new ControlEnregistrerCoordonneesBancaires(controlVerifierCoordonneesBancaires);
        ControlCommander controlCommande = new ControlCommander(controlVerifierIdentification);
        new FrameClient(numClient, controlCommande,
                controlEnregistrerCoordonneesBancaires);
        new FrameClient(numClient2, controlCommande,
                controlEnregistrerCoordonneesBancaires);
    }
}

