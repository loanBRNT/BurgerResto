package modele;

public class Personnel extends Profil {

    //Attributs
    private boolean gerant = false;

    public Personnel(String nom, String prenom, String mdp){
        super(nom,prenom,mdp);
    }

    //Méthodes
    public void definirGerant(){
        gerant = true;
    }

    public boolean isGerant() {
        return gerant;
    }

    @Override
    public String toString() {
        return "Personnel[" +
                "gerant=" + gerant + "," + super.toString() +
                ']';
    }
}
