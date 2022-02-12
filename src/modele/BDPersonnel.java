package modele;

import java.util.Map;
import java.util.TreeMap;

public class BDPersonnel {

    //Attributs
    private Map<Integer, Personnel> listePersonnel = new TreeMap<>();
    private int numeroPersonnel=0;

    //SINGLETON
    private BDPersonnel(){}

    private static class BDPersonnelHolder {
        private final static BDPersonnel instance = new BDPersonnel();
    }

    public static BDPersonnel getInstance(){
        return BDPersonnel.BDPersonnelHolder.instance;
    }

    //METHODES
    public void ajouterPersonnel(Personnel personnel){
        listePersonnel.put(numeroPersonnel,personnel);
        numeroPersonnel++;
    }

    public int connexionPersonnel(String login, String mdp){
        int idClient = -1;
        Personnel p;
        for (int i : listePersonnel.keySet()){
            p = listePersonnel.get(i);
            if (p.verifierCorrespondanceProfil(login, mdp)){
                p.connexionProfil();
                idClient = i;
            }
        }
        return idClient;
    }

    public Personnel trouverPersonnel(int numeroPersonnel){
        return listePersonnel.get(numeroPersonnel);
    }

    @Override
    public String toString(){
        return "BDPersonnel [listePersonnel=" + listePersonnel + "]";
    }
}
