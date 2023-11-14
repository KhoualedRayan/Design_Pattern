package personnage;

public abstract class Personnage {
    private int pointsDeVie;
    private int niveau;
    private String nom;

    public Personnage(int pointsDeVie, int niveau, String nom) {
        this.pointsDeVie = pointsDeVie;
        this.niveau = niveau;
        this.nom = nom;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
