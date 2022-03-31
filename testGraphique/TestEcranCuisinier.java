import controleur.*;
import modele.AlimentMenu;
import modele.ProfilUtilisateur;
import modele.ThreadViderCommandeJour;
import vueGraphique.FrameClient;
import vueGraphique.FrameCuisinier;

public class TestEcranCuisinier {
    public static void main(String[] args) {
		// Mise en place de l'environnement
		ControlCreerProfil controlCreerProfil = new ControlCreerProfil();
		ControlAjouterAlimentMenu controlAjouterAlimentCarte = new ControlAjouterAlimentMenu(new ControlVerifierIdentification());
		ControlSIdentifier controlSIdentifier = new ControlSIdentifier();

		controlAjouterAlimentCarte.ajouterAliment(AlimentMenu.HAMBURGER, "baconBurger");
		controlAjouterAlimentCarte.ajouterAliment(AlimentMenu.HAMBURGER, "chickenBurger");
		controlAjouterAlimentCarte.ajouterAliment(AlimentMenu.HAMBURGER, "cheeseBurger");
		controlAjouterAlimentCarte.ajouterAliment(AlimentMenu.ACCOMPAGNEMENT, "frites");
		controlAjouterAlimentCarte.ajouterAliment(AlimentMenu.ACCOMPAGNEMENT, "pommesChips");
		controlAjouterAlimentCarte.ajouterAliment(AlimentMenu.BOISSON, "coca");
		controlAjouterAlimentCarte.ajouterAliment(AlimentMenu.BOISSON, "orangeBubbles");

		//Cr�ation et connexion des profils clients
		controlCreerProfil.creerProfil(ProfilUtilisateur.CLIENT, "Dupond", "Hector", "cdh");
		int numClient = controlSIdentifier.sIdentifier(ProfilUtilisateur.CLIENT, "Hector.Dupond", "cdh");

		controlCreerProfil.creerProfil(ProfilUtilisateur.CLIENT, "Durand", "Jacques", "cdj");
		int numClient2 = controlSIdentifier.sIdentifier(ProfilUtilisateur.CLIENT, "Jacques.Durand", "cdj");
		
		//Cr�ation et connexion des profils cuisiniers
        controlCreerProfil.creerProfil(ProfilUtilisateur.PERSONNEL, "Martin",
                "Stephane", "pms");
        int numCuisinier = controlSIdentifier.sIdentifier(
                ProfilUtilisateur.PERSONNEL, "Stephane.Martin", "pms");
        
        controlCreerProfil.creerProfil(ProfilUtilisateur.PERSONNEL, "Bernard",
                "Christophe", "pbc");
        int numCuisinier2 = controlSIdentifier.sIdentifier(
                ProfilUtilisateur.PERSONNEL, "Christophe.Bernard", "pbc");

		// Initialisation controleur du cas & cas Inclus/etendu
		ControlVerifierIdentification controlVerifierIdentification = new ControlVerifierIdentification();
		ControlVerifierCoordonneesBancaires controlVerifierCoordonneesBancaire = new ControlVerifierCoordonneesBancaires();
		ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires = new ControlEnregistrerCoordonneesBancaires(
				controlVerifierCoordonneesBancaire);
		ControlConsulterHistorique controlConsulterHistorique = new ControlConsulterHistorique();

		// cas commander
		ControlCommander controlCommande = new ControlCommander(controlVerifierIdentification, controlConsulterHistorique);
		new FrameClient(numClient, controlCommande,
				controlEnregistrerCoordonneesBancaires,controlConsulterHistorique);
		new FrameClient(numClient2, controlCommande,
				controlEnregistrerCoordonneesBancaires,controlConsulterHistorique);
        
      
        // cas visualisation commande du jour
        ControlVisualiserCommandeJour cVisualisationCommandeJour = new ControlVisualiserCommandeJour(controlVerifierIdentification);
        new FrameCuisinier(numCuisinier, cVisualisationCommandeJour);
        new FrameCuisinier(numCuisinier2, cVisualisationCommandeJour);
        
        //Thread
        ThreadViderCommandeJour threadViderCommande = new ThreadViderCommandeJour();
        threadViderCommande.start();
    }

}
