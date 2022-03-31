import controleur.*;
import modele.AlimentMenu;
import modele.ProfilUtilisateur;
//import modele.ThreadViderCommandeJour;
import modele.ThreadViderCommandeJour;
import vueconsole.BoundaryCommander;
import vueconsole.BoundaryEnregistrerCoordonneesBancaires;
import vueconsole.BoundaryVisualiserCommandeJour;

public class TestCasVisualiserCommandeJour {

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

		//Création et connexion des profils clients
		controlCreerProfil.creerProfil(ProfilUtilisateur.CLIENT, "Dupond", "Hector", "cdh");
		int numClient = controlSIdentifier.sIdentifier(ProfilUtilisateur.CLIENT, "Hector.Dupond", "cdh");

		controlCreerProfil.creerProfil(ProfilUtilisateur.CLIENT, "Durand", "Jacques", "cdj");
		int numClient2 = controlSIdentifier.sIdentifier(ProfilUtilisateur.CLIENT, "Jacques.Durand", "cdj");
		
		//Création et connexion des profils cuisiniers
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

		// Initialisation vue du cas & cas Inclus/etendu
		BoundaryEnregistrerCoordonneesBancaires boundaryEnregistrerCoordonneesBancaires = new BoundaryEnregistrerCoordonneesBancaires(
				controlEnregistrerCoordonneesBancaires);
		BoundaryCommander boundaryCommander = new BoundaryCommander(new ControlCommander(controlVerifierIdentification, controlConsulterHistorique),
				boundaryEnregistrerCoordonneesBancaires);

		// creation pour la visualisation de la commande
		ControlVisualiserCommandeJour controlVisualiserCommandeJour = new ControlVisualiserCommandeJour(controlVerifierIdentification);
		BoundaryVisualiserCommandeJour boundaryVisualiserCommandeJour = new BoundaryVisualiserCommandeJour(controlVisualiserCommandeJour);
		boundaryVisualiserCommandeJour.visualiserCommandeJour(numCuisinier);
		boundaryVisualiserCommandeJour.visualiserCommandeJour(numCuisinier2);

		// Thread
		ThreadViderCommandeJour threadViderCommande = new ThreadViderCommandeJour();
		threadViderCommande.start();

		//Lancement du test
		System.out.println("\nCommande client 1");
		boundaryCommander.commander(numClient);
		System.out.println("\nCommande client 2");
		boundaryCommander.commander(numClient2);
	}

}
