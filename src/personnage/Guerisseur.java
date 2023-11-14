package personnage;

import arme.Arme;
import visiteur.VisiteurPers;

public class Guerisseur extends Personnage{
    private int sagesse;

    public Guerisseur(int pointsDeVie, int niveau, String nom, Arme arme, int sagesse) {
        super(pointsDeVie, niveau, nom, arme);
        this.sagesse = sagesse;
    }

    public int getSagesse() {
        return sagesse;
    }

    public void setSagesse(int sagesse) {
        this.sagesse = sagesse;
    }

    @Override
    public void accept(VisiteurPers vp) {
        vp.visitGuerisseur(this);
    }
    public String toString() {
        return "Guerisseur{" +
                "pointsDeVie=" + getPointsDeVie() +
                ", niveau=" + getNiveau() +
                ", nom='" + getNom() + '\'' +
                ", arme=" + getArme() +
                ", sagesse='" + getSagesse() + '\'' +
                '}';
    }
}
