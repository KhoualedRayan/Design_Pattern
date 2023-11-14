package personnage;

import arme.Arme;

public class Sorcier extends Personnage{
    private int intelligence;

    public Sorcier(int pointsDeVie, int niveau, String nom, Arme arme, int intelligence) {
        super(pointsDeVie, niveau, nom, arme);
        this.intelligence = intelligence;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}
