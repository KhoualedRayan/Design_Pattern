package personnage;

import arme.Arme;
import visiteur.VisiteurPers;

public class Roi extends Personnage{
    private int force;
    private String royaume;

    public Roi(int pointsDeVie, int niveau, String nom, Arme arme, int force, String royaume) {
        super(pointsDeVie, niveau, nom, arme);
        this.force = force;
        this.royaume = royaume;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public String getRoyaume() {
        return royaume;
    }

    public void setRoyaume(String royaume) {
        this.royaume = royaume;
    }

    @Override
    public void accept(VisiteurPers vp) {
        vp.visitRoi(this);
    }

    public String toString() {
        return "Roi{" +
                "pointsDeVie=" + getPointsDeVie() +
                ", niveau=" + getNiveau() +
                ", nom='" + getNom() + '\'' +
                ", arme=" + getArme() +
                ", force='" + getForce() + ',' +
                ", royaume='" + getRoyaume() + '\'' +
                '}';
    }
}
