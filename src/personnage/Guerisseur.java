package personnage;

import arme.Arme;
import arme.BaguetteMagique;
import visiteur.VisiteurPers;

public class Guerisseur extends Personnage{
    private int sagesse;

    public Guerisseur(int pointsDeVie, int niveau, String nom, Arme arme, int sagesse) {
        super(pointsDeVie, niveau, nom, arme);
        this.sagesse = sagesse;
    }

    public Guerisseur() {
        setPointsDeVieMax(5);
        setSagesse(5);
        setPointsDeVie(5);
        setNiveau(1);
        Arme arme = new BaguetteMagique(1,"BaguetteMagique",1.0,2);
        setArme(arme);

    }
    public void soinPersonnage(Personnage p){
        if(isPeutAttaquer()){
            if(p.getPointsDeVie()+sagesse >= p.getPointsDeVieMax())
                p.setPointsDeVie(p.getPointsDeVieMax());
            else
                p.setPointsDeVie(p.getPointsDeVie()+sagesse);
        }
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
