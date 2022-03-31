package vueGraphique;

import controleur.ControlCommander;
import controleur.ControlConsulterHistorique;
import controleur.ControlEnregistrerCoordonneesBancaires;
import controleur.ControlVerifierCoordonneesBancaires;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameClient extends JFrame {
    // Les attributs metiers (ex : numClient)
    private int numClient;
    // Declaration et creation des elements graphiques (JLabel)
    // Declaration et creation de la barre de menu (MenuBar)
    private MenuBar menuBar = new MenuBar();
    // Declaration et creation des differents panels
    private JPanel panContents = new JPanel();

    private PanCommander panCommander;
    private PanModifierProfil panModifierProfil = new PanModifierProfil();
    private PanHistorique panHistorique;

    private JPanel panAccueil = new JPanel();
    // Declaration et creation du gestionnaire des cartes (CardLayout)
    private CardLayout carte = new CardLayout();

        // Le constructeur
        public FrameClient (int numClient, ControlCommander controlCommander, ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires, ControlConsulterHistorique controlConsulterHistorique) {
            // initialisation des attributs metiers
            this.numClient = numClient;
            // mise en forme de la frame (titre, dimension, ...)
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("Burger Resto");
            setSize(900,400);
            // initialisation des differents panels : appel a leur methode d'initialisation

            PanEnregistrerCoordonneesBancaire panEnregistrerCoordonneesBancaire = new PanEnregistrerCoordonneesBancaire(controlEnregistrerCoordonneesBancaires);

            panCommander = new PanCommander(controlCommander, panEnregistrerCoordonneesBancaire);
            panCommander.initialisation();
            panModifierProfil.initialisation();

            panHistorique = new PanHistorique(controlConsulterHistorique);
            panHistorique.initialisation();
            panEnregistrerCoordonneesBancaire.initialisation();
            // ajout des pannels dans le ContentPane de la Frame
            panContents.setLayout(carte);

            panContents.add(panCommander,"Commander");
            panCommander.add(panEnregistrerCoordonneesBancaire, "ENREGISTRER_COORDONNEES_BANCAIRE");
            panContents.add(panHistorique, "Historique");
            panContents.add(panModifierProfil, "Modifier Profil");

            getContentPane().add(panContents);
            // mise en page : mises en place des cartes
            initialisationAcceuil();
            // mise en place du menu
            initialisationMenu();
            setMenuBar(menuBar);
            // appel a la methode d'initialisation du menu
            // appel a la methode d'initialisation de la page d'accueil (optionnel)


            this.setVisible(true);
        }


        private void initialisationMenu() {

            MenuItem commander = new MenuItem("Commander");
            commander.addActionListener(event -> {
                panCommander.commander(numClient);
                carte.show(panContents, "Commander");
            });

            MenuItem historique = new MenuItem("Historique");
            historique.addActionListener(event -> {
                panHistorique.historique(numClient);
                carte.show(panContents, "Historique");
            });

            MenuItem modifierProfil = new MenuItem("Modifier Profil");
            modifierProfil.addActionListener(event -> carte.show(panContents, "Modifier Profil"));

            Menu monCompte = new Menu("Mon Compte");
            Menu deconnexion = new Menu("deconnexion");

            monCompte.add(commander);
            monCompte.add(historique);
            monCompte.add(modifierProfil);

            menuBar.add(monCompte);
            menuBar.add(deconnexion);
        }

        private void initialisationAcceuil(){
            panAccueil.setBackground(Color.ORANGE);
            JLabel texteAccueil = new JLabel("Bienvenue à Burger Resto");
            texteAccueil.setFont(new Font("Calibri", Font.BOLD, 24));
            panAccueil.add(texteAccueil);
            panAccueil.setVisible(true);
            panContents.add(panAccueil, "ECRAN_ACCUEIL");
            carte.show(panContents, "ECRAN_ACCUEIL");
        }
}
