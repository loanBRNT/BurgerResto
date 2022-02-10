package modele;

public class Client extends Profil{

    public Client(String nom, String prenom, String mdp) {
        super(nom, prenom, mdp);
    }

    @Override
    public String toString() {
        return "Client[" +
                 super.toString() +
                ']';
    }
}
