package personnage;

public class Sorcier extends Personnage{
    private int intelligence;

    public Sorcier(int pointsDeVie, int niveau, String nom, int intelligence) {
        super(pointsDeVie, niveau, nom);
        this.intelligence = intelligence;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}
