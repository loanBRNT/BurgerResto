package controleur;

import modele.*;

public class ControlCreerProfil {

    //Attributs
    private BDClient bdClient = BDClient.getInstance();
    private BDPersonnel bdPersonnel = BDPersonnel.getInstance();

    //Méthodes
    public void creerProfil(ProfilUtilisateur profilUtilisateur, String nom, String prenom, String mdp){
        Profil profil = FabriqueProfil.creerProfil(profilUtilisateur,nom,prenom,mdp);

        if (profilUtilisateur == ProfilUtilisateur.CLIENT){
            bdClient.ajouterClient((Client) profil);
        } else {
            bdPersonnel.ajouterPersonnel((Personnel) profil);
        }
    }

    public String visualiserBDUtilisateur(){
        return (bdPersonnel + "\n" + bdClient);
    }
}
