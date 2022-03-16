package vueGraphique;

import controleur.ControlCommander;
import controleur.ControlVerifierCoordonneesBancaires;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanCommander extends JPanel implements IUseEnregistrerCoordonneesBancaires {

    // controleurs du cas + panel des cas inclus ou etendus en lien avec un acteur
    private ControlCommander controlCommander;
    private PanEnregistrerCoordonneesBancaire panEnregistrerCoordonneesBancaire;

    // les attributs metiers (ex : numClient)
    private int numeroHamburger=0;
    private int numeroBoisson=0;
    private int numeroAccompagnement=0;
    private int numClient;
    // Les elements graphiques :

    // Declaration et creation des polices d'ecritures
    private Font policeTitre = new Font("Calibri", Font.BOLD, 24);
    private Font policeParagraphe = new Font("Calibri",Font.HANGING_BASELINE, 16);

    // Declaration et creation des ComboBox
    private JComboBox<String> comboBoxHamburger = new JComboBox<>();
    private JComboBox<String> comboBoxBoisson = new JComboBox<>();
    private JComboBox<String> comboBoxAccompagnement = new JComboBox<>();

    // Declaration et creation des Button
    private JButton validerCommande = new JButton();
    private Box boxValiderChoix = Box.createVerticalBox();

    // Declaration et creation des TextArea

    // Declaration et creation des Labels
    private JLabel numeroCommande = new JLabel();

    // Mise en page : les Box
    private Box boxMiseEnPageCommande = Box.createVerticalBox();
    private Box boxChoixHamburger = Box.createHorizontalBox();
    private Box boxChoixBoisson = Box.createHorizontalBox();
    private Box boxChoixAccompagnateur = Box.createHorizontalBox();
    private Box boxMiseEnPageNumeroCommande = Box.createVerticalBox();

    public PanCommander (ControlCommander controlCommander, PanEnregistrerCoordonneesBancaire panEnregistrerCoordonneesBancaire) {
        // initialisation des attributs metiers
        // initilaisation du controleur du cas + panels
        this.controlCommander = controlCommander;
        this.panEnregistrerCoordonneesBancaire = panEnregistrerCoordonneesBancaire;
        // des cas inclus ou etendus en lien avec un acteur
    }

    //Methode d'initialisation du panel
    public void initialisation() {
        // mise en forme du panel (couleur, ...)
        this.setBackground(new Color(255,0,0));
        // creation des differents elements graphiques (JLabel, Combobox, Button, TextAera ...)
        JLabel texteCommander = new JLabel("Votre Menu");
        texteCommander.setFont(policeTitre);

        JLabel texteHamburger = new JLabel("Choisissez Votre Hamburger");
        texteHamburger.setFont(policeParagraphe);

        JLabel texteAccompagnement = new JLabel("Choisissez Votre Accompagnement");
        texteAccompagnement.setFont(policeParagraphe);

        JLabel texteBoisson = new JLabel("Choisissez Votre Boisson");
        texteBoisson.setFont(policeParagraphe);

        JLabel texteValider = new JLabel("Valider");
        texteValider.setFont(policeTitre);

        comboBoxHamburger.addActionListener(e -> numeroHamburger = comboBoxHamburger.getSelectedIndex());
        comboBoxAccompagnement.addActionListener(e -> numeroAccompagnement = comboBoxAccompagnement.getSelectedIndex());
        comboBoxBoisson.addActionListener(e -> numeroBoisson = comboBoxBoisson.getSelectedIndex());

        validerCommande.setText("Valider");
        validerCommande.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ( numeroHamburger != 0 && numeroAccompagnement != 0
                        && numeroBoisson != 0) {
                    validationCartePaiement();
                }
            }
        });

        JLabel texteNumeroCommandeTitre = new JLabel("Votre commande");
        texteNumeroCommandeTitre.setFont(policeTitre);
        numeroCommande.setFont(policeParagraphe);

        // mise en page : placements des differents elements graphiques dans des Box

        boxMiseEnPageCommande.add(texteCommander);
        boxMiseEnPageCommande.add(Box.createRigidArea(new Dimension(0,30)));

        boxChoixHamburger.add(texteHamburger);
        boxChoixBoisson.add(texteBoisson);
        boxChoixAccompagnateur.add(texteAccompagnement);

        boxChoixHamburger.add(Box.createRigidArea(new Dimension(30, 0)));
        boxChoixBoisson.add(Box.createRigidArea(new Dimension(30, 0)));
        boxChoixAccompagnateur.add(Box.createRigidArea(new Dimension(30, 0)));

        boxValiderChoix.add(validerCommande);

        boxMiseEnPageNumeroCommande.add(numeroCommande);
        boxMiseEnPageNumeroCommande.add(texteNumeroCommandeTitre);
        boxMiseEnPageNumeroCommande.add(Box.createRigidArea(new Dimension(0, 30)));

        // mise en page : placements des differentes box dans une box principale
        boxChoixHamburger.add(comboBoxHamburger);
        boxChoixBoisson.add(comboBoxBoisson);
        boxChoixAccompagnateur.add(comboBoxAccompagnement);

        boxMiseEnPageCommande.add(boxChoixHamburger);
        boxMiseEnPageCommande.add(Box.createRigidArea(new Dimension(0,30)));
        boxMiseEnPageCommande.add(boxChoixBoisson);
        boxMiseEnPageCommande.add(Box.createRigidArea(new Dimension(0,30)));
        boxMiseEnPageCommande.add(boxChoixAccompagnateur);

        boxMiseEnPageCommande.add(boxValiderChoix);
        boxMiseEnPageNumeroCommande.add(numeroCommande);
        // mise en page : ajout de la box principale dans le panel
        this.add(boxMiseEnPageCommande);
        this.add(boxMiseEnPageNumeroCommande);
    }

    // Methode correspondante au nom du cas
    public void commander(int numClient ) {
        boxMiseEnPageCommande.setVisible(true);
        boxMiseEnPageNumeroCommande.setVisible(false);
        this.numClient = numClient;
        controlCommander.verifierIdentification(numClient);
        affichageMenu();
    }

    // Methodes privees pour le bon deroulement du cas
    private void affichageMenu(){
        List<String> listeHamburger = controlCommander.donnerListeHamburger();
        List<String> listeBoisson = controlCommander.donnerListeBoisson();
        List<String> listeAccompagnement = controlCommander.donnerListeAccompagnement();

        comboBoxHamburger.removeAllItems();
        comboBoxAccompagnement.removeAllItems();
        comboBoxBoisson.removeAllItems();

        comboBoxHamburger.addItem("");
        for (String nom : listeHamburger){
            comboBoxHamburger.addItem(nom);
        }

        comboBoxAccompagnement.addItem("");
        for (String nom : listeAccompagnement){
            comboBoxAccompagnement.addItem(nom);
        }

        comboBoxBoisson.addItem("");
        for (String nom : listeBoisson){
            comboBoxBoisson.addItem(nom);
        }
    }

    @Override
    public void retourEnregistrerCoordonneesBancaire(boolean carteValide) {
        this.panEnregistrerCoordonneesBancaire.setVisible(false);
        if(carteValide) this.enregistrerCommande(carteValide);
    }

    public void validationCartePaiement(){
        boolean carteRenseignee = controlCommander.verifierExistenceCarteBancaire(numClient);
        if (!carteRenseignee) {
            boxMiseEnPageCommande.setVisible(false);
            panEnregistrerCoordonneesBancaire.setVisible(true);
            this.repaint();
            panEnregistrerCoordonneesBancaire
                    .enregistrerCoordonneesBancaires(numClient, this);
        } else
            this.enregistrerCommande(carteRenseignee);
    }

    private void enregistrerCommande(boolean carteRenseignee) {
        if (carteRenseignee) {
            int numCommande = controlCommander.enregistrerCommande(numClient, numeroHamburger,
                    numeroAccompagnement, numeroBoisson);
            numeroCommande.setText("Votre numero est : " + numCommande);
        }
        this.setVisible(true);
        boxMiseEnPageCommande.setVisible(false);
        boxMiseEnPageNumeroCommande.setVisible(true);
        this.repaint();
    }
}
