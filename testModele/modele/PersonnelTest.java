package modele;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonnelTest extends ProfilTest{

    @BeforeEach
    void setUp() {
        client = new Client(nomClient,prenomClient,mdpClient);
        personnel = new Personnel(nomPersonnel,prenomPersonnel,mdpPersonnel);
    }

    @Test
    void definirGerant() {
        personnel.definirGerant();
        assertTrue(personnel.isGerant(),"le personnel est bien un gérant OK");
    }

    @Test
    void isGerant() {
        assertFalse(personnel.isGerant(),"le personnel n'est pas un gérant OK");
        personnel.definirGerant();
        assertTrue(personnel.isGerant(),"le personnel est bien un gérant OK");
    }

    @Test
    void testToString() {
        assertEquals(personnel.toString(),"Personnel[" +
                "gerant=" + personnel.isGerant() +
                ",nom='" + nomPersonnel + '\'' +
                ", prenom='" + prenomPersonnel + '\'' +
                ", mdp='" + mdpPersonnel + '\'' +
                ", login='" + prenomPersonnel + "." + nomPersonnel + '\'' + ']');
    }

}