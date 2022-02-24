import controleur.ControlCreerProfil;
import controleur.ControlEnregistrerCoordonneesBancaires;
import controleur.ControlSIdentifier;
import controleur.ControlVerifierCoordonneesBancaires;
import modele.ProfilUtilisateur;
import vueconsole.BoundaryEnregistrerCoordonneesBancaires;

public class TestCasEnregistrerCoordonneesBancaires {

	public static void main(String[] args) {
		// Mise en place de l'environnement
		ControlCreerProfil controlCreerProfil = new ControlCreerProfil();
		controlCreerProfil.creerProfil(ProfilUtilisateur.CLIENT, "Dupond",
				"Hector", "cdh");
		ControlSIdentifier controlSIdentifier = new ControlSIdentifier();
		int numClient = controlSIdentifier.sIdentifier(
				ProfilUtilisateur.CLIENT, "Hector.Dupond", "cdh");

		// Initialisation controleur du cas
		ControlVerifierCoordonneesBancaires controlVerifierCoordonneesBancaires = new ControlVerifierCoordonneesBancaires();
		ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires = new ControlEnregistrerCoordonneesBancaires(controlVerifierCoordonneesBancaires);
		// Initialisation vue du cas

		BoundaryEnregistrerCoordonneesBancaires boundaryEnregistrerCoordonneesBancaires = new BoundaryEnregistrerCoordonneesBancaires(controlEnregistrerCoordonneesBancaires);
		// Lancement du cas
		boundaryEnregistrerCoordonneesBancaires.enregistrerCoordonneesBancaires(numClient);
		// Verification de la bonne realisation du cas
		System.out.println("VERIFICATION");
		System.out.println(controlSIdentifier.visualiserBDUtilisateur());
		

		// Resultat du test
		// VERIFICATION
		// Veuillez saisir votre numero de carte bancaire
		// 12315415
		// Veuillez saisir la date d'expiration de votre carte bancaire (MMAA)
		// 1207
		// VERIFICATION
		// BDPersonnel [listePersonnel={}]
		// BDClient [listeClient={0=Client [nom=Dupond, prenom=Hector,
		// login=Hector.Dupond, mdp=cdh, connecte=true, historiqueCommandes=[],
		// carteBancaire=CarteBancaire [numeroCarte=12315415, dateCarte=1207]]}]

	}


}
