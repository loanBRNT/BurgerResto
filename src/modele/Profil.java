package modele;

public abstract class Profil {
    private String nom;
    private String prenom;
    private String mdp;
    private String login;

    public Profil(String nom, String prenom, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.login = prenom + "." + nom;
    }

    @Override
    public String toString() {
        return  "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mdp='" + mdp + '\'' +
                ", login='" + login + '\'';
    }
}
