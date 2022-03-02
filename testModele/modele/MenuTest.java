package modele;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    private Menu menu;
    private Hamburger hamburger = new Hamburger("Rosti Montagnard");
    private Boisson boisson = new Boisson("Sprite");
    private Accompagnement accompagnement = new Accompagnement("Potatoes");


    @BeforeEach
    void setUp() {
        Assumptions.assumeTrue(hamburger != null);
        Assumptions.assumeTrue(boisson != null);
        Assumptions.assumeTrue(accompagnement != null);

        menu = Menu.getInstance();
    }

    @Test
    void menu(){
        assertNotNull(menu,"get instance OK");
    }

    @Test
    void ajouterAlimen() {
        menu.ajouterAliment(hamburger);
        assertTrue(menu.getListeHamburger().contains(hamburger),"Ajout d'un Hamburger OK");

        menu.ajouterAliment(boisson);
        assertTrue(menu.getListeBoisson().contains(boisson),"Ajout d'une boisson OK");

        menu.ajouterAliment(accompagnement);
        assertTrue(menu.getListeAccompagnement().contains(accompagnement),"ajout d'un accompagnement OK");

    }

    @Test
    void testToString() {
        assertEquals( menu.toString(),"Menu [listeHamburger=[], " +
                "listeBoisson=[], listeAccompagneent=[]]");
    }

    @Test
    void choixHamburger() {
        Hamburger h = menu.choixHamburger(1);
        assertEquals(h.getNom(),hamburger.getNom(),"Choix Burger OK");
    }

    @Test
    void choixBoisson() {
        Boisson b = menu.choixBoisson(1);
        assertEquals(b.getNom(),boisson.getNom(),"choix Boisson OK");
    }

    @Test
    void choixAccompagnement() {
        Accompagnement a = menu.choixAccompagnement(1);
        assertEquals(a.getNom(),accompagnement.getNom(),"Choix Accompagnement ok");
    }


}