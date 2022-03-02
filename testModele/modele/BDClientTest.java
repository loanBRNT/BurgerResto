package modele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BDClientTest {
    private BDClient bdClient;
    private Client client = new Client("Bernat","Loan","123456");
    private int NOMBRE_CLIENT = 0;

    @BeforeEach
    void setUp() {
        bdClient = BDClient.getInstance();
        NOMBRE_CLIENT = bdClient.getNumeroClient();
    }

    @Test
    void getInstance() {
        assertNotNull(bdClient,"get instance OK");
    }

    @Test
    void ajouterClient() {
        bdClient.ajouterClient(client);
        NOMBRE_CLIENT++;
        assertEquals(NOMBRE_CLIENT,bdClient.getNumeroClient(),"Client bian ajouté OK");
        Map<Integer, Client> liste = bdClient.getListeClient();
        Client c = liste.get(NOMBRE_CLIENT-1);
        assertEquals(c.getLogin(),client.getLogin(),"login OK");
        assertEquals(c.getMdp(),client.getMdp(),"Mdp OK");
    }

    @Test
    void connexionClient() {

        bdClient.ajouterClient(client);
        NOMBRE_CLIENT++;

        int idClient = bdClient.connexionClient("patrick.sebastien","les sardines");
        assertEquals(-1,idClient,"sebastien n'existe pas OK");

        idClient = bdClient.connexionClient("Loan.Bernat","123456");
        assertEquals(0,idClient,"id du client ok");
    }

    @Test
    void trouverClient() {
        Client c = bdClient.trouverClient(0);
        assertEquals(c.getLogin(),client.getLogin(),"login OK");
        assertEquals(c.getMdp(),client.getMdp(),"Mdp OK");
    }

    @Test
    void testToString() {
        assertEquals("BDClient [listeClient={}]",bdClient.toString(),"to string OK");
    }
}