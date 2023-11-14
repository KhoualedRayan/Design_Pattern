package arme;

public abstract class Arme {
    private int degat;
    private String nom;
    private double poids;

    public Arme(int degat, String nom, double poids) {
        this.degat = degat;
        this.nom = nom;
        this.poids = poids;
    }

    public int getDegat() {
        return degat;
    }

    public void setDegat(int degat) {
        this.degat = degat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public abstract String toString() ;
}
