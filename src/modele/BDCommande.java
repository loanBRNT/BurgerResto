package modele;

import java.util.HashMap;
import java.util.Map;

public class BDCommande {
    private Map<Integer, Commande> mapCommandes = new HashMap<>();
    private int numeroCommande=0;

    private BDCommande(){}

    private static class BDCommandeHolder{

        private final static BDCommande instance = new BDCommande();

    }

    public static BDCommande getInstance(){
        return BDCommandeHolder.instance;
    }

    public int enregistrerCommande(int numClient, Hamburger hamburger, Accompagnement accompagnement, Boisson boisson){

        return 0;
    }
}
