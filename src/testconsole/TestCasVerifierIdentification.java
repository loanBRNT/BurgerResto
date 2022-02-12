package testconsole;

import controleur.ControlCreerProfil;
import controleur.ControlSIdentifier;
import controleur.ControlVerifierIdentification;
import modele.ProfilUtilisateur;

public class TestCasVerifierIdentification {

	public static void main(String[] args) {

		// Mise en place de l'environnement
		ControlCreerProfil controlCreerProfil = new ControlCreerProfil();
		controlCreerProfil.creerProfil(ProfilUtilisateur.GERANT, "Martin",
				"Victor", "gmv");
		controlCreerProfil.creerProfil(ProfilUtilisateur.CLIENT, "Dupond",
				"Hector", "cdh");
		
		ControlSIdentifier controlSIdentifier = new ControlSIdentifier();
		int numGerant = controlSIdentifier.sIdentifier(
				ProfilUtilisateur.GERANT, "Victor.Martin", "gmv");
		int numClient = controlSIdentifier.sIdentifier(
				ProfilUtilisateur.CLIENT, "Hector.Dupond", "cdh");

		// Initialisation controleur du cas
		ControlVerifierIdentification controlVerifierIdentification = new ControlVerifierIdentification();
		// Initialisation vue du cas

		// Lancement du cas
		boolean identificationGerantOK = controlVerifierIdentification
				.verifierIdentification(ProfilUtilisateur.GERANT, numGerant);
		boolean identificationClientOK = controlVerifierIdentification
				.verifierIdentification(ProfilUtilisateur.CLIENT, numClient);
		boolean identificationClientKO = controlVerifierIdentification
				.verifierIdentification(ProfilUtilisateur.CLIENT, 2);

		// Verification de la bonne realisation du cas
		System.out.println("VERIFICATION");
		System.out.println("Gerant identifier : " + identificationGerantOK);
		System.out.println("Client identifier : " + identificationClientOK);
		System.out.println("Erreur d'identification : " + identificationClientKO);

		// Resultat du test
		// VERIFICATION
		// Gerant identifier : true
		// Client identifier : true
		// Erreur d'identification : false

	}


}
