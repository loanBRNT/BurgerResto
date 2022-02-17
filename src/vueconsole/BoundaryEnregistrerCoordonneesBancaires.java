package vueconsole;

import controleur.ControlEnregistrerCoordonneesBancaires;

public class BoundaryEnregistrerCoordonneesBancaires {

    private ControlEnregistrerCoordonneesBancaires controlEnregisterDonneBanquaire;

    public BoundaryEnregistrerCoordonneesBancaires(ControlEnregistrerCoordonneesBancaires c){
        controlEnregisterDonneBanquaire = c;
    }

    public boolean enregistrerCoordonneesBancaires(int numClient){
        System.out.println("Veuillez entrer votre numéro de Carte Bancaire");
        int numeroCarte = Clavier.entrerClavierInt();
        System.out.println("Veuillez saisir la date d'expiration de votre carte de bancaire (MMAA)");
        int dateCarte = Clavier.entrerClavierInt();

        boolean carteValide = controlEnregisterDonneBanquaire.enregistrerCoordonneesBancaires(numClient,numeroCarte,dateCarte);

        if (!carteValide){
            System.out.println("Votre carte n'est pas valide, votre commande ne peut aboutir");
        }

        return carteValide;
    }

}
