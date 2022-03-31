package vueconsole;

import controleur.ControlVisualiserCommandeJour;
import modele.Commande;
import modele.ProfilUtilisateur;
import modele.PropertyName;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.stream.StreamSupport;

public class BoundaryVisualiserCommandeJour implements PropertyChangeListener {
    private ControlVisualiserCommandeJour controlVisualiserCommandeJour;

    public BoundaryVisualiserCommandeJour(ControlVisualiserCommandeJour controlVisualiserCommandeJour){
        this.controlVisualiserCommandeJour = controlVisualiserCommandeJour;
        //this.controlVisualiserCommandeJour.setListener(PropertyName.ENREGISTRER_COMMANDE.toString(),this);
    }

    public void visualiserCommandeJour(int numPersonnel){
        if (controlVisualiserCommandeJour.verifierIdentification(numPersonnel, ProfilUtilisateur.PERSONNEL)){
            this.controlVisualiserCommandeJour.setListener(PropertyName.ENREGISTRER_COMMANDE.toString(), this);
            controlVisualiserCommandeJour.setListener(PropertyName.VIDER_COMMANDE_JOUR.toString(), this);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        PropertyName choix = PropertyName.valueOf(propertyName);

        switch (choix){
            case ENREGISTRER_COMMANDE -> {
                Commande commande = (Commande) evt.getNewValue();
                Fichier.ecrire("Commande n" + commande.getNumeroCommandeAttribuee() + " : " + commande.getHamburger() + ", "
                        + commande.getAccompagnement() + ", " + commande.getBoisson() + ".","ecranCuisinier");
            }
            case VIDER_COMMANDE_JOUR -> {
                Fichier.effacer();
            }
            default -> {
                System.out.println("ERREUR");
            }
        }
    }
}
