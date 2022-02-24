package modele;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfilTest {
    protected String nomClient = "Parker";
    protected String prenomClient = "Peter";
    protected String mdpClient = "AM SPIDERMAN";

    protected String nomPersonnel = "Smith";
    protected String prenomPersonnel = "Will";
    protected String mdpPersonnel = "Men in Black";

    protected Client client;
    protected Personnel personnel;

    @BeforeEach
    void setUp() {
        client = new Client(nomClient,prenomClient,mdpClient);
        personnel = new Personnel(nomPersonnel,prenomPersonnel,mdpPersonnel);
    }

    @Test
    void verifierCorrespondanceProfil() {
        assertFalse(client.verifierCorrespondanceProfil(personnel.getLogin(),personnel.getMdp()),"verif correspondance client-Personnel ok");
        assertTrue(client.verifierCorrespondanceProfil(client.getLogin(),client.getMdp()), "verif correspondance client-client ok");
    }

    @Test
    void connexionProfil() {
        client.connexionProfil();
        assertTrue(client.isConnecte(),"connexion client ok");
    }

    @Test
    void isConnecte() {
        assertFalse(client.isConnecte(),"le client n'est pas connecté OK");
        client.connexionProfil();
        assertTrue(client.isConnecte(),"le client est connecté ok");
    }


}