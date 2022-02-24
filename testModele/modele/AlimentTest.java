package modele;

import modele.Accompagnement;
import modele.Boisson;
import modele.Hamburger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlimentTest {
    private Hamburger hamburger;
    private String nomHamb = "King Fries Bacon";
    private Boisson boisson;
    private String nomBoiss = "Coca chery";
    private Accompagnement accompagnement;
    private String nomAcc = "Rosti Montagnard";

    @BeforeEach
    void setUp() {
        accompagnement = new Accompagnement(nomAcc);
        boisson = new Boisson(nomBoiss);
        hamburger = new Hamburger(nomHamb);
    }

    @Test
    void testToString() {
        assertEquals(accompagnement.toString(),"Aliment [" +
                "nom=" + nomAcc +
                ']');
        assertEquals(boisson.toString(), "Aliment [" +
                "nom=" + nomBoiss +
                ']');
        assertEquals(hamburger.toString(), "Aliment [" +
                "nom=" + nomHamb +
                ']');
    }

    @Test
    void getNom() {
        assertEquals(accompagnement.getNom(), nomAcc, "Nom Accompagnement OK");
        assertEquals(boisson.getNom(), nomBoiss, "Nom Boisson OK");
        assertEquals(hamburger.getNom(), nomHamb, "Nom Hamburger OK");
    }
}