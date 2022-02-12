package modele;

import java.util.HashMap;
import java.util.Map;

public class BDClient {
    private Map<Integer, Client> listeClient = new HashMap<>();
    private int numeroClient=0;

    //SINGLETON

    private BDClient(){}

    private static class BDClientHolder {
        private final static BDClient instance = new BDClient();
    }

    public static BDClient getInstance(){
        return BDClientHolder.instance;
    }

    //METHODES

    public void ajouterClient(Client client){
        listeClient.put(numeroClient,client);
        numeroClient++;
    }

    public int connexionClient(String login, String mdp){
        int idClient = -1;
        Client c;
        for (int i : listeClient.keySet()){
            c = listeClient.get(i);
            if (c.verifierCorrespondanceProfil(login, mdp)){
                c.connexionProfil();
                idClient = i;
            }
        }
        return idClient;
    }

    public Client trouverClient(int numeroClient){
        return listeClient.get(numeroClient);
    }

    @Override
    public String toString(){
        return "BDClient [listeClient=" + listeClient + "]";
    }
}
