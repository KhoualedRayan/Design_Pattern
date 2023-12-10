package personnage;

import arme.Arme;
import equipe.Groupe;
import etat.EnAttaque;
import etat.Etat;
import etat.Actif;
import strategie.Neutre;
import strategie.StrategieCombat;
import visiteur.VisiteurPers;

public abstract class Personnage  implements Groupe {
    private StrategieCombat strategieCombat;
    private int pointsDeVie;
    private int pointsDeVieMax;
    private int niveau;
    private String nom;
    private Arme arme;
    private Etat etat;
    private boolean peutAttaquer;


    public Personnage() {
        strategieCombat = new Neutre();
        etat = new Actif(this);
    }

    public Personnage(int pointsDeVie, int niveau, String nom, Arme arme) {
        this.pointsDeVie = pointsDeVie;
        pointsDeVieMax = pointsDeVie;
        this.niveau = niveau;
        this.nom = nom;
        this.arme = arme;
        strategieCombat = new Neutre();
        etat = new Actif(this);
    }
    public void action(){
        this.getEtat().action_Tour();
    }

    public int getPointsDeVieMax() {
        return pointsDeVieMax;
    }

    public void setPointsDeVieMax(int pointsDeVieMax) {
        this.pointsDeVieMax = pointsDeVieMax;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
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
        if(this.getPointsDeVie()<1)
            peutAttaquer =false;
        if(peutAttaquer) {
            strategieCombat.attaquer(this.getArme().getDegat(), personnage);
        }
        else {
            System.out.println(this.getNom() + " ne peut pas attaquer !");
        }
        this.action();
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

    public void setPeutAttaquer(boolean peutAttaquer) {
        this.peutAttaquer = peutAttaquer;
    }

    public boolean isPeutAttaquer() {
        return peutAttaquer;
    }

    public abstract String toString();
}
