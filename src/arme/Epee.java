package arme;

public class Epee extends Arme{
    private int longueur;

    public Epee(int degat, String nom, double poids, int longueur) {
        super(degat, nom, poids);
        this.longueur = longueur;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }
}
