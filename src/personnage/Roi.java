package personnage;

public class Roi extends Personnage{
    private int force;
    private String royaume;

    public Roi(int pointsDeVie, int niveau, String nom, int force, String royaume) {
        super(pointsDeVie, niveau, nom);
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
}
