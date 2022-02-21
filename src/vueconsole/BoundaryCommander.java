package vueconsole;

import controleur.ControlCommander;
import modele.Hamburger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoundaryCommander {

    private ControlCommander controlCommander;
    private BoundaryEnregistrerCoordonneesBancaires boundaryEnregistrerDonneBanquaire;

    public BoundaryCommander(ControlCommander c, BoundaryEnregistrerCoordonneesBancaires b){
        controlCommander = c;
        boundaryEnregistrerDonneBanquaire = b;
    }

    public void commander(int numClient){
        if (controlCommander.verifierIdentification(numClient)){

            int numeroHamb = selectionnerBurger();

            int numeroAccompagnement = selectionnerAccompagnement();

            int numeroBoisson = selectionnerBoisson();

            boolean carteRenseigne = controlCommander.verifierExistenceCarteBancaire(numClient);
            if (!carteRenseigne){
                carteRenseigne = boundaryEnregistrerDonneBanquaire.enregistrerCoordonneesBancaires(numClient);
            }

            if (carteRenseigne){
                int numCommande = controlCommander.enregistrerCommande(numClient,numeroHamb,numeroAccompagnement,numeroBoisson);
                System.out.println("Votre numéro de commande est le : " + numCommande);
            } else {
                System.out.println("La commande a avortée");
            }
        }
    }

    private int selectionnerBurger(){
        List<String> listeHamburger = controlCommander.donnerListeHamburger();
        System.out.println("Veuillez sélectionner le numéro de votre Hamburger");
        int nb = 1;
        for (String nomHamb : listeHamburger){
            System.out.println("-" + nb + " " + nomHamb);
            nb++;
        }
        return Clavier.entrerClavierInt();
    }

    private int selectionnerAccompagnement(){
        List<String> listeAccompagnement = controlCommander.donnerListeAccompagnement();
        System.out.println("Veuillez sélectionner le numéro de votre accompagnement");
        int nb = 1;
        for (String nomAcc : listeAccompagnement){
            System.out.println("-" + nb + " " + nomAcc);
            nb++;
        }
        return Clavier.entrerClavierInt();
    }

    private int selectionnerBoisson(){
        List<String> listeBoisson = controlCommander.donnerListeBoisson();
        System.out.println("Veuillez sélectionner le numéro de votre boisson");
        int nb = 1;
        for (String nomBoisson : listeBoisson){
            System.out.println("-" + nb + " " + nomBoisson);
            nb++;
        }
        return Clavier.entrerClavierInt();
    }

}
