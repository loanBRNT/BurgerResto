package modele;

public abstract class Aliment{

    private String nom;

    public Aliment(String n){
        nom = n;
    }

    @Override
    public String toString() {
        return "Aliment [" +
                "nom=" + nom +
                ']';
    }
}
