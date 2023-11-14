package personnage;

public class Guerisseur extends Personnage{
    private int sagesse;

    public Guerisseur(int pointsDeVie, int niveau, String nom, int sagesse) {
        super(pointsDeVie, niveau, nom);
        this.sagesse = sagesse;
    }

    public int getSagesse() {
        return sagesse;
    }

    public void setSagesse(int sagesse) {
        this.sagesse = sagesse;
    }
}
