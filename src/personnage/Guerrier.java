package personnage;

public class Guerrier extends Personnage {
    private int force;
    public Guerrier(int pointsDeVie, int niveau, String nom, int force) {
        super(pointsDeVie, niveau, nom);
        this.force = force;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }
}
