package modele;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FabriqueProfilTest {
    private Client client = new Client("Bernat","Loan","123456");
    private Personnel personnel = new Personnel("McDonald","Ronald","maxibestof");

    @BeforeEach
    void setUp() {
        Assumptions.assumeTrue(personnel != null, "initialisation personnel ok");
        Assumptions.assumeTrue(client != null, "initialisation client ok");

    }


    @Test
    void creerProfil() {

        Profil p = FabriqueProfil.creerProfil(ProfilUtilisateur.PERSONNEL,"McDonald","Ronald","maxibestof");
        assertEquals(p.getNom(),personnel.getNom(),"Nom simmillaire ok");
        assertEquals(p.getPrenom(),personnel.getPrenom(),"Prénom simmillaire ok");
        assertEquals(p.getMdp(),personnel.getMdp(),"Mdp simmillaire ok");
        Personnel profil = (Personnel) p;
        assertEquals(profil.isGerant(),personnel.isGerant(),"Les deux ne sont pas gérant ok");

        p = FabriqueProfil.creerProfil(ProfilUtilisateur.GERANT,"McDonald","Ronald","maxibestof");
        assertEquals(p.getNom(),personnel.getNom(),"Nom simmillaire ok");
        assertEquals(p.getPrenom(),personnel.getPrenom(),"Prénom simmillaire ok");
        assertEquals(p.getMdp(),personnel.getMdp(),"Mdp simmillaire ok");
        profil = (Personnel) p;
        assertEquals(!profil.isGerant(),personnel.isGerant(),"profil est gérant alors que personnel non OK");

        p = FabriqueProfil.creerProfil(ProfilUtilisateur.CLIENT,"Bernat","Loan","123456");
        assertEquals(p.getNom(),client.getNom(),"Nom simmillaire ok");
        assertEquals(p.getPrenom(),client.getPrenom(),"Prénom simmillaire ok");
        assertEquals(p.getMdp(),client.getMdp(),"Mdp simmillaire ok");
        assertEquals(p.getMdp(),client.getMdp(),"Mdp simmillaire ok");
    }
}