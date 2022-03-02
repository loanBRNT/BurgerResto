package modele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BDPersonnelTest {
    private BDPersonnel bdPersonnel;
    private Personnel personnel = new Personnel("Bernat","Loan","123456");
    private int NOMBRE_PERSONNEL = 0;

    @BeforeEach
    void setUp() {
        bdPersonnel = BDPersonnel.getInstance();
        NOMBRE_PERSONNEL = bdPersonnel.getNumeroPersonnel();
    }

    @Test
    void getInstance() {
        assertNotNull(bdPersonnel,"get instance OK");
    }

    @Test
    void ajouterPersonnel() {
        bdPersonnel.ajouterPersonnel(personnel);
        NOMBRE_PERSONNEL++;
        assertEquals(NOMBRE_PERSONNEL,bdPersonnel.getNumeroPersonnel(),"ajout ok");

        Map<Integer, Personnel> listePersonnel = bdPersonnel.getListePersonnel();
        Personnel p = listePersonnel.get(NOMBRE_PERSONNEL-1);
        assertEquals(personnel.getLogin(),p.getLogin());
        assertEquals(personnel.getMdp(),p.getMdp());
    }

    @Test
    void connexionPersonnel() {
        bdPersonnel.ajouterPersonnel(personnel);
        NOMBRE_PERSONNEL++;

        int idPersonnel = bdPersonnel.connexionPersonnel("patrick.sebastien","les sardines");
        assertEquals(-1,idPersonnel,"sebastien n'existe pas OK");

        idPersonnel = bdPersonnel.connexionPersonnel("Loan.Bernat","123456");
        assertEquals(0,idPersonnel,"id du personnel ok");
    }

    @Test
    void trouverPersonnel() {
        Personnel p = bdPersonnel.trouverPersonnel(0);
        assertEquals(personnel.getLogin(),p.getLogin());
        assertEquals(personnel.getMdp(),p.getMdp());
    }

    @Test
    void testToString() {
        assertEquals("BDPersonnel [listePersonnel=" + "{}" + "]",bdPersonnel.toString());
    }
}