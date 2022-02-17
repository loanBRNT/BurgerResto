package modele;

public class Client extends Profil{

    private CarteBancaire cb = null;

    public Client(String nom, String prenom, String mdp) {
        super(nom, prenom, mdp);
    }

    @Override
    public String toString() {
        return "Client[" +
                 super.toString() +
                 ",carteBancaire=" + cb +']';
    }

    public void enregistrerCoordonnesBancaires(int numeroCarte, int dateCarte){
        cb = new CarteBancaire(numeroCarte,dateCarte);
    }

    public boolean verifierExistenceCarteBancaire(){
        return (cb != null);
    }
}
