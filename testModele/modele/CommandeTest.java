package modele;

import org.junit.jupiter.api.*;

class CommandeTest {
    private Hamburger hamburger = new Hamburger("Rosti Montagnard");
    private Boisson boisson = new Boisson("Coca chery");
    private Accompagnement accompagnement = new Accompagnement("King Fries Bacon");
    private Commande commande;

    @BeforeEach
    void setUp() throws Exception{
        Assumptions.assumeTrue(hamburger != null, "Hamburger non null");
        Assumptions.assumeTrue(boisson != null, "Boisson non null");
        Assumptions.assumeTrue(accompagnement != null, "Accompagnement non null");
        commande = new Commande(100,hamburger,accompagnement,boisson);
        commande.resetNumCommande();
    }

    @Test
    void testCommande(){
        Assertions.assertTrue(commande != null, "erreur constructeur commande");
    }

    @Test
    void getNumeroCommandeAttribuee() {
        Assertions.assertTrue(commande.getNumeroCommandeAttribuee() == 1, "numero de la Commande Ok");
    }

    @Test
    void getNumClient() {
        Assertions.assertTrue(commande.getNumClient() == 100, "numero Client OK");
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