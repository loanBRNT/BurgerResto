package modele;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FabriqueAlimentTest {
    private Hamburger hamburger = new Hamburger("Rosti Montagnard");
    private Boisson boisson = new Boisson("Sprite");
    private Accompagnement accompagnement = new Accompagnement("Potatoes");

    @BeforeEach
    void setUp() {
        Assumptions.assumeTrue(hamburger != null);
        Assumptions.assumeTrue(boisson != null);
        Assumptions.assumeTrue(accompagnement != null);
    }

    @Test
    void creerAliment() {
        Aliment aliment = FabriqueAliment.creerAliment(AlimentMenu.HAMBURGER,"Rosti Montagnard");
        assertEquals(aliment.getNom(),hamburger.getNom());

        aliment = FabriqueAliment.creerAliment(AlimentMenu.BOISSON,"Sprite");
        assertEquals(aliment.getNom(),boisson.getNom());

        aliment = FabriqueAliment.creerAliment(AlimentMenu.ACCOMPAGNEMENT,"Potatoes");
        assertEquals(aliment.getNom(),accompagnement.getNom());
    }
}