package modele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest extends ProfilTest{
    private CarteBancaire carteBancaire = new CarteBancaire(123456,1210);


    @BeforeEach
    void setUp() {
        client = new Client(nomClient,prenomClient,mdpClient);
        personnel = new Personnel(nomPersonnel,prenomPersonnel,mdpPersonnel);
    }


    @Test
    void enregistrerCoordonnesBancaires() {
        client.enregistrerCoordonnesBancaires(123456,1210);
        assertEquals(client.toString(),"Client[" +
                "nom='" + nomClient + '\'' +
                ", prenom='" + prenomClient + '\'' +
                ", mdp='" + mdpClient + '\'' +
                ", login='" + prenomClient + "." + nomClient + '\'' +
                ",carteBancaire=" + "CarteBancaire [" +
                "numeroCarte=" + carteBancaire.getNumeroCarte() +
                ", dateCarte=" + carteBancaire.getDateCarte() +
                ']' +']');;
    }

    @Test
    void verifierExistenceCarteBancaire() {
        assertFalse(client.verifierExistenceCarteBancaire(), "Carte bancaire ok");
        client.enregistrerCoordonnesBancaires(123456,1210);
        assertTrue(client.verifierExistenceCarteBancaire(), "Carte bancaire ok");
    }
}