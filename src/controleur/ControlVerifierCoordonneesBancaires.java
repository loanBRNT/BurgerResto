package controleur;

public class ControlVerifierCoordonneesBancaires {


    public boolean verifierCoordonnesBancaires(int numeroCarte, int dateCarte){ //Le but du TP n'est pas ici, je test juste le mois et le jour
        int mois = dateCarte/100;
        if (mois > 12) return false;
        int jour = dateCarte - mois*100;
        if (jour > 31 || jour < 1) return false;
        return true;
    }
}
