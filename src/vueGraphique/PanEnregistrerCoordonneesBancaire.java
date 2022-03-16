package vueGraphique;

import controleur.ControlEnregistrerCoordonneesBancaires;
import controleur.ControlVerifierCoordonneesBancaires;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanEnregistrerCoordonneesBancaire extends JPanel {
    // controleurs du cas + panel des cas inclus ou etendus en lien avec un acteur
    private ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires;
    private IUseEnregistrerCoordonneesBancaires panAppelant;

    // les attributs metiers (ex : numClient)
    private int numClient;

    // Les elements graphiques :

    // Declaration et creation des polices d'ecritures
    private Font policeTitre = new Font("Calibri", Font.BOLD, 24);
    private Font policeParagraphe = new Font("Calibri",Font.HANGING_BASELINE, 16);
    private Font policeAremplacer = new Font("Arial", Font.ITALIC,12);
    private Font policeChoixUtilisateur = new Font("Arial", Font.TRUETYPE_FONT,12);

    // Declaration et creation des ComboBox

    // Declaration et creation des Button

    // Declaration et creation des TextArea
    private TextArea textAreaNumeroCarte = new TextArea();
    private TextArea textAreaDateExpiration = new TextArea();

    // Declaration et creation des Labels

    // Mise en page : les Box
    private Box boxMiseEnPageCoordonneesBancaires = Box.createVerticalBox();
    private Box boxNumeroCarte = Box.createHorizontalBox();
    private Box boxValiditeCarte = Box.createHorizontalBox();
    private Box boxValiderCarte = Box.createHorizontalBox();

    public PanEnregistrerCoordonneesBancaire (ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires) {
        // initialisation des attributs metiers
        // initilaisation du controleur du cas + panels
        this.controlEnregistrerCoordonneesBancaires = controlEnregistrerCoordonneesBancaires;
        // des cas inclus ou etendus en lien avec un acteur
    }

    //Methode d'initialisation du panel
    public void initialisation() {
        // mise en forme du panel (couleur, ...)
        this.setBackground(Color.YELLOW);

        // creation des differents elements graphiques (JLabel, Combobox, Button, TextAera ...)
        JLabel texteCoordonneeBancaire = new JLabel("Entrer vos coordonnées bancaires");
        texteCoordonneeBancaire.setFont(policeTitre);

        JLabel texteNumeroCarteBancaire = new JLabel("Entrer le numéro de votre carte bancaire");
        texteNumeroCarteBancaire.setFont(policeParagraphe);

        JLabel texteValiditeCarte = new JLabel("Entrer la date d’expiration de votre carte bancaire");
        texteValiditeCarte.setFont(policeParagraphe);

        JButton validationCoordonneeBancaire = new JButton();
        validationCoordonneeBancaire.setText("Valider");
        validationCoordonneeBancaire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numeroCarte = Integer.parseInt(textAreaNumeroCarte.getText());
                int dateCarte = Integer.parseInt(textAreaDateExpiration.getText());
                traitementCoordonneesBancaires(numeroCarte, dateCarte);
            }
        });

        textAreaNumeroCarte.setMaximumSize(new Dimension(120,20));
        textAreaDateExpiration.setMaximumSize(new Dimension(60,20));
        textAreaDateExpiration.setForeground(Color.GRAY);
        textAreaDateExpiration.setFont(policeAremplacer);

        textAreaDateExpiration.addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent arg0) {}
            public void mousePressed(MouseEvent arg0) {}
            public void mouseExited(MouseEvent arg0) {}
            public void mouseEntered(MouseEvent arg0) {}
            public void mouseClicked(MouseEvent arg0) {
                textAreaDateExpiration.setText(null);
                textAreaDateExpiration.setFont(policeChoixUtilisateur);
                textAreaDateExpiration.setForeground(Color.black);
            }
        });

        // mise en page : placements des differents elements graphiques dans des Box
        boxValiderCarte.add(validationCoordonneeBancaire);
        boxNumeroCarte.add(texteNumeroCarteBancaire);
        boxValiditeCarte.add(texteValiditeCarte);

        boxNumeroCarte.add(textAreaNumeroCarte);
        boxValiditeCarte.add(textAreaDateExpiration);

        // mise en page : placements des differentes box dans une box principale
        boxMiseEnPageCoordonneesBancaires.add(texteCoordonneeBancaire);
        boxMiseEnPageCoordonneesBancaires.add(boxValiderCarte);
        boxMiseEnPageCoordonneesBancaires.add(boxNumeroCarte);
        boxMiseEnPageCoordonneesBancaires.add(boxValiditeCarte);

        // mise en page : ajout de la box principale dans le panel
        this.add(boxMiseEnPageCoordonneesBancaires);
        boxMiseEnPageCoordonneesBancaires.setVisible(true);
        this.setVisible(false);
    }

    // Methode correspondante au nom du cas
    public void enregistrerCoordonneesBancaires(int numClient, IUseEnregistrerCoordonneesBancaires panAppelant) {
        this.numClient = numClient;
        this.panAppelant = panAppelant;
        textAreaNumeroCarte.setText("");
        textAreaDateExpiration.setText("MMAA");
        this.setVisible(true);
        this.repaint();
    }

    // Methodes privees pour le bon deroulement du cas
    private void traitementCoordonneesBancaires(int numeroCarte, int dateCarte) {
        boolean carteValide = controlEnregistrerCoordonneesBancaires.enregistrerCoordonneesBancaires(numClient, numeroCarte, dateCarte);
        panAppelant.retourEnregistrerCoordonneesBancaire(carteValide);
    }
}
