package testconsole;

import controleur.ControlCreerProfil;
import controleur.ControlSIdentifier;
import modele.ProfilUtilisateur;
import vueconsole.BoundarySIdentifierClient;

public class TestCasSIdentifierClient {

    public static void main(String[] args) {
        // Mise en place de l'environnement
        ControlCreerProfil controlCreerProfil = new ControlCreerProfil();
        controlCreerProfil.creerProfil(ProfilUtilisateur.CLIENT, "Dupond", "Hector", "cdh");

        // Initialisation controleur du cas & cas Inclus/etendu
        ControlSIdentifier controlSIdentifier = new ControlSIdentifier();
        // Initialisation vue du cas
        BoundarySIdentifierClient boundarySIdentifierClient = new BoundarySIdentifierClient(controlSIdentifier);
        // Lancement du cas
        int numClient = boundarySIdentifierClient.sIdentifierClient();

        // Verification de la bonne realisation du cas
        System.out.println("VERIFICATION");
        System.out.println("numero du client = " + numClient);
        System.out.println(controlSIdentifier.visualiserBDUtilisateur());

        // Resultat du test
        // Veuilliez entrer votre login
        // Hector.Dupond
        // Veuillez entrer votre mot de passe
        // cdh
        // VERIFICATION
        // numero du client = 0
        // BDPersonnel [listePersonnel={}]
        // BDClient [listeClient={0=Client [nom=Dupond, prenom=Hector,
        // login=Hector.Dupond, mdp=cdh, connecte=true}]
    }


}