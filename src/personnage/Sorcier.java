package personnage;

import arme.Arme;
import arme.BatonDeSorcier;
import arme.Epee;
import etat.Actif;
import etat.Blesse;
import etat.Endormi;
import etat.Etat;
import visiteur.VisiteurPers;

public class Sorcier extends Personnage{
    private int intelligence;

    public Sorcier(int pointsDeVie, int niveau, String nom, Arme arme, int intelligence) {
        super(pointsDeVie, niveau, nom, arme);
        this.intelligence = intelligence;
    }
    public Sorcier(){
        setPointsDeVieMax(4);
        setIntelligence(5);
        setPointsDeVie(4);
        setNiveau(1);
        Arme arme = new BatonDeSorcier(3,"BatonSorcier",2.0,"Dodo");
        setArme(arme);
    }
    public void sort(Personnage personnage){
        BatonDeSorcier batonDeSorcier= (BatonDeSorcier) this.getArme();
        switch (batonDeSorcier.getPouvoir()){
            case "Dodo":
                personnage.setEtat(new Endormi(personnage));
                break;
            case "Blessure":
                personnage.setEtat(new Blesse(personnage));
                break;
            case "Purge":
                personnage.setEtat(new Actif(personnage));
                break;
        }
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public void accept(VisiteurPers vp) {
        vp.visitSorcier(this);
    }

    @Override
    public String toString() {
        return "Sorcier{" +
                "pointsDeVie=" + getPointsDeVie() +
                ", niveau=" + getNiveau() +
                ", nom='" + getNom() + '\'' +
                ", arme=" + getArme() +
                ", intelligence='" + getIntelligence() + '\'' +
                '}';
    }
}
