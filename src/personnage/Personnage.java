package personnage;

import arme.Arme;
import equipe.Groupe;
import strategie.Neutre;
import strategie.StrategieCombat;
import visiteur.VisiteurPers;

public abstract class Personnage  implements Groupe {
    private StrategieCombat strategieCombat;
    private int pointsDeVie;
    private int niveau;
    private String nom;
    private Arme arme;

    public Personnage() {
    }

    public Personnage(int pointsDeVie, int niveau, String nom, Arme arme) {
        this.pointsDeVie = pointsDeVie;
        this.niveau = niveau;
        this.nom = nom;
        this.arme = arme;
        strategieCombat = new Neutre();
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
    public void attaquer(Personnage personnage){
        strategieCombat.attaquer(this.getArme().getDegat(),personnage);
    }
    public void subir(int degat){
        strategieCombat.subir(degat,this);
    }
    public StrategieCombat getStrategieCombat() {
        return strategieCombat;
    }

    public void setStrategieCombat(StrategieCombat strategieCombat) {
        this.strategieCombat = strategieCombat;
    }

    public abstract String toString();
}
