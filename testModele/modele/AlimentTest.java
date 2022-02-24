package modele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlimentTest {
    private Hamburger hamburger;
    private Boisson boisson;
    private Accompagnement accompagnement;

    @BeforeEach
    void setUp() {
        accompagnement = new Accompagnement("King Fries Bacon");
        boisson = new Boisson("Coca chery");
        hamburger = new Hamburger("Rosti Montagnard");
    }

    @Test
    void testToString() {
    }

    @Test
    void getNom() {
    }
}