package controleur;

import modele.BDCommande;
import modele.ProfilUtilisateur;

import java.beans.PropertyChangeListener;

public class ControlVisualiserCommandeJour {
    private BDCommande bdCommande = BDCommande.getInstance();
    private ControlVerifierIdentification controlVerifierIdentification;

    public ControlVisualiserCommandeJour(ControlVerifierIdentification controlVerifierIdentification){
        this.controlVerifierIdentification = controlVerifierIdentification;
    }

    public void setListener(String propertyName, PropertyChangeListener listener){
        bdCommande.addPropertyChangeListener(propertyName, listener);
    }

    public boolean verifierIdentification(int numPersonnel, ProfilUtilisateur profilPersonnel){
        return controlVerifierIdentification.verifierIdentification(profilPersonnel,numPersonnel);
    }
}
