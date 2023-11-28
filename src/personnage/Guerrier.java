package personnage;

import arme.Arme;
import visiteur.VisiteurPers;

public class Guerrier extends Personnage {
    private int force;

    public Guerrier(int pointsDeVie, int niveau, String nom, Arme arme, int force) {
        super(pointsDeVie, niveau, nom, arme);
        this.force = force;
    }
    public Guerrier(){

    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    @Override
    public void accept(VisiteurPers vp) {
        vp.visitGuerrier(this);
    }
    public String toString() {
        return "Guerrier{" +
                "pointsDeVie=" + getPointsDeVie() +
                ", niveau=" + getNiveau() +
                ", nom='" + getNom() + '\'' +
                ", arme=" + getArme() +
                ", force='" + getForce() + '\'' +
                '}';
    }
}
