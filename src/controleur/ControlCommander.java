package controleur;

import modele.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ControlCommander {

    private ControlVerifierIdentification controlVerifierIdentification;
    private ControlConsulterHistorique controlConsulterHistorique;
    private Menu menu = Menu.getInstance();
    private BDClient bdClient = BDClient.getInstance();
    private BDCommande bdCommande = BDCommande.getInstance();

    public ControlCommander(ControlVerifierIdentification c, ControlConsulterHistorique ch){
        controlVerifierIdentification = c;
        controlConsulterHistorique = ch;
    }

    public boolean verifierIdentification(int numclient){
        return controlVerifierIdentification.verifierIdentification(ProfilUtilisateur.CLIENT,numclient);
    }

    public List<String> donnerListeHamburger(){
        List<String> listeNomHamb = new ArrayList<>();
        List<Hamburger> listHamb = menu.getListeHamburger();
        for (Hamburger hamb : listHamb){
            listeNomHamb.add(hamb.getNom());
        }
        return listeNomHamb;
    }

    public List<String> donnerListeAccompagnement(){
        List<String> listeNomAccompagnement = new ArrayList<>();
        List<Accompagnement> listeAccompagnement = menu.getListeAccompagnement();
        for (Accompagnement accompagnement : listeAccompagnement){
            listeNomAccompagnement.add(accompagnement.getNom());
        }
        return listeNomAccompagnement;
    }

    public List<String> donnerListeBoisson(){
        List<String> listeNomBoisson = new ArrayList<>();
        List<Boisson> listeBoisson = menu.getListeBoisson();
        for (Boisson boisson : listeBoisson){
            listeNomBoisson.add(boisson.getNom());
        }
        return listeNomBoisson;
    }

    public boolean verifierExistenceCarteBancaire(int numClient){
        Client client = bdClient.trouverClient(numClient);
        if (client != null) {
            return client.verifierExistenceCarteBancaire();
        }
        return false;
    }

    public int enregistrerCommande(int numClient, int numeroHamburger, int numeroAccompagnement, int numeroBoisson){
        Hamburger hamburger = menu.choixHamburger(numeroHamburger);
        Accompagnement accompagnement = menu.choixAccompagnement(numeroAccompagnement);
        Boisson boisson = menu.choixBoisson(numeroBoisson);
        int numCommande =  bdCommande.enregistrerCommande(numClient,hamburger,accompagnement,boisson);
        controlConsulterHistorique.ajouterCommandeAuClient(numClient,numCommande);
        return numCommande;
    }
}
