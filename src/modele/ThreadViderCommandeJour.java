package modele;

import java.util.Calendar;

public class ThreadViderCommandeJour extends Thread{
    private boolean continuerBoucle = true;
    private BDCommande bdCommande = BDCommande.getInstance();

    public ThreadViderCommandeJour(){
        super("Thread vidage commande");
    }

    public void arret(){
        continuerBoucle = false;
    }

    public void run(){
        do {
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (testHeureSuppression()){
                bdCommande.viderCommandeJour();
            }
        } while (continuerBoucle);
    }

    public boolean testHeureSuppression(){
        Calendar calendar = Calendar.getInstance();
        int minuteActuelle = calendar.get(Calendar.MINUTE);

        return minuteActuelle == 43;
    }
}
