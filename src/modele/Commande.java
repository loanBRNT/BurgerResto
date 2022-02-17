package modele;

public class Commande {
    private int numClient;
    private Hamburger hamburger;
    private Accompagnement accompagnement;
    private Boisson boisson;
    private int numeroCommandeAttribuee;
    private int numeroCommande = 0;

    public int getNumeroCommandeAttribuee() {
        return numeroCommandeAttribuee;
    }
}
