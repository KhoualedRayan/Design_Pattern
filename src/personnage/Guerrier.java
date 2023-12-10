package personnage;

import arme.Arme;
import arme.BaguetteMagique;
import arme.Epee;
import visiteur.VisiteurPers;

public class Guerrier extends Personnage {
    private int force;

    public Guerrier(int pointsDeVie, int niveau, String nom, Arme arme, int force) {
        super(pointsDeVie, niveau, nom, arme);
        this.force = force;
    }
    public Guerrier(){
        setPointsDeVieMax(8);
        setForce(5);
        setPointsDeVie(8);
        setNiveau(1);
        Arme arme = new Epee(4,"EpeeGuerrier",2.0,2);
        setArme(arme);
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
