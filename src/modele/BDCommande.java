package modele;

import jdk.jshell.spi.ExecutionControl;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;

public class BDCommande {
    private Map<Integer, Commande> mapCommandes = new HashMap<>();
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

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

        support.firePropertyChange(PropertyName.ENREGISTRER_COMMANDE.toString(), null, commande);

        return commande.getNumeroCommandeAttribuee();
    }

    public void viderCommandeJour(){
        mapCommandes.clear();
        Commande.resetNumCommande();
        support.firePropertyChange(PropertyName.VIDER_COMMANDE_JOUR.toString(), null, null);
    }

    public Commande trouverCommande(int numCommande){
        return mapCommandes.get(numCommande);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener){
        support.addPropertyChangeListener(propertyName,listener);
    }
}
