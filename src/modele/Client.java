package modele;

import java.util.HashMap;
import java.util.Map;

public class Client extends Profil {
    private Map<String,Commande> historiqueCommande = new HashMap<>();

    private CarteBancaire cb = null;

    public Client(String nom, String prenom, String mdp) {
        super(nom, prenom, mdp);
    }

    @Override
    public String toString() {
        return "Client[" +
                 super.toString() +
                 ",carteBancaire=" + cb +']';
    }

    public void enregistrerCoordonnesBancaires(int numeroCarte, int dateCarte){
        cb = new CarteBancaire(numeroCarte,dateCarte);
    }

    public boolean verifierExistenceCarteBancaire(){
        return (cb != null);
    }

    public void ajouterCommandeAHistorique(String date, Commande commande){
        historiqueCommande.put(date, commande);
    }

    public String historiqueClientString(){
        String message = "";
        for (String date : historiqueCommande.keySet()){
            message += " - " + date + " : " + historiqueCommande.get(date).toString() + "\n";
        }
        return message;
    }

    public Map<String, Commande> getHistoriqueCommande() {
        return historiqueCommande;
    }
}
