package arme;

public class BaguetteMagique extends Arme{
    private int soin;

    public BaguetteMagique(int degat, String nom, double poids, int soin) {
        super(degat, nom, poids);
        this.soin = soin;
    }

    public int getSoin() {
        return soin;
    }

    public void setSoin(int soin) {
        this.soin = soin;
    }
}
