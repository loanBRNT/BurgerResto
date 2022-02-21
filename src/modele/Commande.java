package modele;

public class Commande {
    private int numClient;
    private Hamburger hamburger;
    private Accompagnement accompagnement;
    private Boisson boisson;
    private int numeroCommandeAttribuee;
    private static int numeroCommande = 0;

    public Commande(int numClient, Hamburger hamburger, Accompagnement accompagnement, Boisson boisson) {
        numeroCommande++;
        this.numClient = numClient;
        this.hamburger = hamburger;
        this.accompagnement = accompagnement;
        this.boisson = boisson;
        this.numeroCommandeAttribuee = numeroCommande;
    }

    public int getNumeroCommandeAttribuee() {
        return numeroCommandeAttribuee;
    }
}
