package controleur;

import modele.*;

public class ControlAjouterAlimentMenu {

    private ControlVerifierIdentification controlVerifierIdentification;
    private Menu menu = Menu.getInstance();

    public ControlAjouterAlimentMenu(ControlVerifierIdentification c){
        controlVerifierIdentification = c;
    }

    //Methodes

    public boolean verifierIdentification(ProfilUtilisateur profilUtilisateur, int numeroProfil){
        return controlVerifierIdentification.verifierIdentification(profilUtilisateur, numeroProfil);
    }

    public void ajouterAliment(AlimentMenu typeAliment, String nom){
        switch (typeAliment){
            case HAMBURGER:
                menu.ajouterAliment((Hamburger) FabriqueAliment.creerAliment(typeAliment, nom));
                break;

            case BOISSON:
                menu.ajouterAliment((Boisson) FabriqueAliment.creerAliment(typeAliment, nom));
                break;

            default:
                menu.ajouterAliment((Accompagnement) FabriqueAliment.creerAliment(typeAliment, nom));
                break;
        }
    }

    public String visualiserMenu() {
        return menu.toString();
    }
}
