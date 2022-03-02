package modele;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BDCommandeTest {
    private BDCommande bdCommande;
    private Hamburger hamburger = new Hamburger("Rosti Montagnard");
    private Boisson boisson = new Boisson("Coca chery");
    private Accompagnement accompagnement = new Accompagnement("King Fries Bacon");

    @BeforeEach
    void setUp() {
        Assumptions.assumeTrue(hamburger != null, "Hamburger non null");
        Assumptions.assumeTrue(boisson != null, "Boisson non null");
        Assumptions.assumeTrue(accompagnement != null, "Accompagnement non null");

        bdCommande = BDCommande.getInstance();
    }

    @Test
    void getInstance() {
        assertNotNull(bdCommande,"constrcuteur ok");
    }

    @Test
    void enregistrerCommande() {
        int nb = bdCommande.enregistrerCommande(10,hamburger,accompagnement,boisson);
        assertEquals(1,nb);
        nb = bdCommande.enregistrerCommande(11,hamburger,accompagnement,boisson);
        assertEquals(2,nb);
    }
}