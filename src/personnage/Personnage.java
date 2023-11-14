package personnage;

import arme.Arme;
import visiteur.VisiteurPers;

public abstract class Personnage {
    private int pointsDeVie;
    private int niveau;
    private String nom;
    private Arme arme;

    public Personnage(int pointsDeVie, int niveau, String nom, Arme arme) {
        this.pointsDeVie = pointsDeVie;
        this.niveau = niveau;
        this.nom = nom;
        this.arme = arme;
    }


    public int getPointsDeVie() {
        return pointsDeVie;
    }
    public abstract void accept(VisiteurPers vp);
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

    public Arme getArme() {
        return arme;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }

    public abstract String toString();
}
