package controleur;

import modele.BDClient;
import modele.BDCommande;
import modele.Client;
import modele.Commande;
import vueconsole.Fichier;

import java.util.Calendar;
import java.util.Map;

public class ControlConsulterHistorique {
    private BDCommande bdCommande = BDCommande.getInstance();
    private BDClient bdClient = BDClient.getInstance();

    public void ajouterCommandeAuClient(int numClient, int numCommande){
        Client client = bdClient.trouverClient(numClient);
        if (client != null){
            Calendar calendar = Calendar.getInstance();
            String time = "" + calendar.getTime();
            Commande commande = bdCommande.trouverCommande(numCommande);
            client.ajouterCommandeAHistorique(time,commande);
            Fichier.ecrire(time + " : " + commande.toString(),"historique" + numClient);
        }
    }

    public String consulterHistorique(int numClient){
        Client client = bdClient.trouverClient(numClient);
        String historique;
        if (client != null){
            historique = client.historiqueClientString();
        } else {
            historique = "ERREUR";
        }
        return historique;
    }

    public Map<String, Commande> getHistoriqueClient(int numClient){
        Client client = bdClient.trouverClient(numClient);
        if (client != null){
            return client.getHistoriqueCommande();
        }return null;
    }
}
