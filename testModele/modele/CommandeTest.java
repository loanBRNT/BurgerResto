package modele;

import modele.Accompagnement;
import modele.Boisson;
import modele.Commande;
import modele.Hamburger;
import org.junit.jupiter.api.*;

class CommandeTest {
    private Hamburger hamburger = new Hamburger("Rosti Montagnard");
    private Boisson boisson = new Boisson("Coca chery");
    private Accompagnement accompagnement = new Accompagnement("King Fries Bacon");
    private Commande commande;
    private int NUM_CLIENT = 10;

    @BeforeEach
    void setUp() throws Exception{
        Assumptions.assumeTrue(hamburger != null, "Hamburger non null");
        Assumptions.assumeTrue(boisson != null, "Boisson non null");
        Assumptions.assumeTrue(accompagnement != null, "Accompagnement non null");
        NUM_CLIENT++;
        Commande.resetNumCommande();
        commande = new Commande(NUM_CLIENT,hamburger,accompagnement,boisson);
    }

    @Test
    void testCommande(){
        Assertions.assertTrue(commande != null, "constructeur commande OK");
    }

    @Test
    void getNumeroCommandeAttribuee() {
        Assertions.assertTrue(commande.getNumeroCommandeAttribuee() == 1, "numero de la Commande Ok");
        NUM_CLIENT++;
        commande = new Commande(NUM_CLIENT,hamburger,accompagnement,boisson);
        Assertions.assertTrue(commande.getNumeroCommandeAttribuee() == 2, "numero de la Commande Ok");
    }

    @Test
    void getNumClient() {
        Assertions.assertTrue(commande.getNumClient() == NUM_CLIENT, "numero Client OK");
    }

    @Test
    void getHamburger() {
        Assertions.assertTrue(commande.getHamburger().equals(hamburger), "hamburger OK");
    }

    @Test
    void getAccompagnement() {
        Assertions.assertTrue(commande.getAccompagnement().equals(accompagnement), "accompagnement OK");
    }

    @Test
    void getBoisson() {
        Assertions.assertTrue(commande.getBoisson().equals(boisson), "Boisson OK");
    }
}