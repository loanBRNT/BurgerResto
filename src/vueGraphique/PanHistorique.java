package vueGraphique;

import controleur.ControlConsulterHistorique;
import modele.Commande;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PanHistorique extends JPanel {
    // controleurs du cas + panel des cas inclus ou etendus en lien avec un acteur
    private ControlConsulterHistorique controlConsulterHistorique;

    // les attributs metiers (ex : numClient)
    private int numClient;
    private Map<String, String> mapCommande = new HashMap<>();

    // Les elements graphiques :
    // polices d'ecritures
    private Font policeTitre = new Font("Calibri", Font.BOLD, 24);
    private Font policeParagraphe = new Font("Calibri", Font.HANGING_BASELINE, 16);

    // Mise en page : les Box
    private Box boxMiseEnpage = Box.createVerticalBox();
    private Box boxCommandeJour = Box.createVerticalBox();
    private Box boxCommandes = Box.createVerticalBox();

    public PanHistorique (ControlConsulterHistorique controlConsulterHistorique) {
        this.controlConsulterHistorique = controlConsulterHistorique;
    }

    //Methode d'initialisation du panel
    public void initialisation() {
        // mise en forme du panel (couleur, ...)
        this.setBackground(new Color(0,255,255));
        // creation des differents elements graphiques (JLabel, Combobox, Button, TextAera ...)
        JLabel titre = new JLabel("Votre Historique de Commande");
        titre.setFont(policeTitre);

        // mise en page : placements des differents elements graphiques dans des
        // Box
        this.boxCommandeJour.add(titre);
        this.boxCommandeJour.add(Box.createRigidArea(new Dimension(0, 15)));
        this.boxCommandeJour.add(boxCommandes);
        // mise en page : placements des differentes box dans une box principale
        this.boxMiseEnpage.add(boxCommandeJour);
        // mise en page : ajout de la box principale dans le panel
        this.add(boxMiseEnpage);
    }

    // Methode correspondante au nom du cas
    public void historique(int numClient) {
        this.numClient = numClient;
        Map<String, Commande> mapClient = controlConsulterHistorique.getHistoriqueClient(numClient);
        for (String date : mapClient.keySet()){
            if (!mapCommande.containsKey(date)){
                JLabel label = new JLabel(date + " : " + mapClient.get(date));
                label.setFont(policeParagraphe);
                mapCommande.put(date,mapClient.get(date).toString());
                boxCommandes.add(label);
            }
        }

    }

    // Methodes privees pour le bon deroulement du cas
}
