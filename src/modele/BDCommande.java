package modele;

import java.util.HashMap;
import java.util.Map;

public class BDCommande {
    private Map<Integer, Commande> mapCommandes = new HashMap<>();

    private BDCommande(){}

    private static class BDCommandeHolder{

        private final static BDCommande instance = new BDCommande();

    }

    public static BDCommande getInstance(){
        return BDCommandeHolder.instance;
    }

    public int enregistrerCommande(int numClient, Hamburger hamburger, Accompagnement accompagnement, Boisson boisson){
        Commande commande = new Commande(numClient,hamburger,accompagnement,boisson);
        mapCommandes.put(commande.getNumeroCommandeAttribuee(),commande);
        return commande.getNumeroCommandeAttribuee();
    }
}
