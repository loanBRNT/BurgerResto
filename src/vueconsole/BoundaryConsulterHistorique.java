package vueconsole;

import controleur.ControlConsulterHistorique;

public class BoundaryConsulterHistorique {

    private ControlConsulterHistorique controlConsulterHistorique;

    public BoundaryConsulterHistorique(ControlConsulterHistorique c){
        controlConsulterHistorique = c;
    }

    public void consulterHistorique(int numClient){
        System.out.println("---------------- VOTRE HISTORIQUE DE COMMANDE ----------------");
        System.out.println(controlConsulterHistorique.consulterHistorique(numClient));
    }
}
