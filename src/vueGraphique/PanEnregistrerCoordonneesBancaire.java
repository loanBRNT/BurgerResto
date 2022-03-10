package vueGraphique;

import controleur.ControlEnregistrerCoordonneesBancaires;
import controleur.ControlVerifierCoordonneesBancaires;

import javax.swing.*;
import java.awt.*;

public class PanEnregistrerCoordonneesBancaire extends JPanel {
    // controleurs du cas + panel des cas inclus ou etendus en lien avec un acteur
    private ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires;
    // les attributs metiers (ex : numClient)

    // Les elements graphiques :
    // Declaration et creation des polices d'ecritures
    // Declaration et creation des ComboBox
    // Declaration et creation des Button
    // Declaration et creation des TextArea
    // Declaration et creation des Labels

    // Mise en page : les Box

    public PanEnregistrerCoordonneesBancaire (ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires) {
        // initialisation des attributs metiers
        // initilaisation du controleur du cas + panels
        this.controlEnregistrerCoordonneesBancaires = controlEnregistrerCoordonneesBancaires;
        // des cas inclus ou etendus en lien avec un acteur
    }

    //Methode d'initialisation du panel
    public void initialisation() {
        // mise en forme du panel (couleur, ...)
        this.setBackground(new Color(0,255,255));
        // creation des differents elements graphiques (JLabel, Combobox, Button, TextAera ...)

        // mise en page : placements des differents elements graphiques dans des Box
        // mise en page : placements des differentes box dans une box principale
        // mise en page : ajout de la box principale dans le panel
    }

    // Methode correspondante au nom du cas
    public void enregistrerCoordonneesBancaire( /*parametres metiers*/ ) {
    }

    // Methodes privees pour le bon deroulement du cas
}
