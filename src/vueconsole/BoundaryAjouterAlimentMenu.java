package vueconsole;

import controleur.ControlAjouterAlimentMenu;
import modele.AlimentMenu;
import modele.ProfilUtilisateur;

public class BoundaryAjouterAlimentMenu {

    private ControlAjouterAlimentMenu controlAjouterAlimentMenu;

    public BoundaryAjouterAlimentMenu(ControlAjouterAlimentMenu c){
        controlAjouterAlimentMenu = c;
    }

    public void ajouterAlimentMenu(int numGerant) {
        if (controlAjouterAlimentMenu.verifierIdentification(ProfilUtilisateur.GERANT,numGerant)){
            int choix=0;
            while (!(choix==1 || choix==2 || choix==3)){
                System.out.println("Entrer le numéro du type d'aliment que vous souhaitez ajouter");
                System.out.println("1 : Hamburger\n2 : Accompagnement\n3 : Boisson");
                choix = Clavier.entrerClavierInt();
                if (!(choix==1 || choix==2 || choix==3)){
                    System.out.println("Veuillez entrez 1, 2 ou 3");
                }
            }
            System.out.println("Veuillez entrer le nom de l'aliment :");
            String nomAliment = Clavier.entrerClavierString();


            switch (choix){
                case 1:
                    controlAjouterAlimentMenu.ajouterAliment(AlimentMenu.HAMBURGER, nomAliment);
                    break;

                case 2:
                    controlAjouterAlimentMenu.ajouterAliment(AlimentMenu.ACCOMPAGNEMENT,nomAliment);
                    break;

                case 3:
                    controlAjouterAlimentMenu.ajouterAliment(AlimentMenu.BOISSON,nomAliment);
                    break;

                default:
                    System.out.println("Type d'aliment non reconnu");
                    break;
            }
        }
    }
}
