package modele;

public class CarteBancaire {
    private int numeroCarte;
    private int dateCarte;

    public CarteBancaire(int n, int d) {
        numeroCarte = n;
        dateCarte = d;
    }

    @Override
    public String toString() {
        return "CarteBancaire [" +
                "numeroCarte=" + numeroCarte +
                ", dateCarte=" + dateCarte +
                ']';
    }
}
