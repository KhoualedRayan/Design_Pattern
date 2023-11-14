package arme;

public class BatonDeSorcier extends Arme{
    private String pouvoir;

    public BatonDeSorcier(int degat, String nom, double poids, String pouvoir) {
        super(degat, nom, poids);
        this.pouvoir = pouvoir;
    }

    public String getPouvoir() {
        return pouvoir;
    }

    public void setPouvoir(String pouvoir) {
        this.pouvoir = pouvoir;
    }
}
