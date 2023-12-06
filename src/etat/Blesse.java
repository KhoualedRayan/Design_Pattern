package etat;

import personnage.Personnage;

public class Blesse implements Etat{
    private Personnage personnage;
    private int degat;
    private int tour_restant;

    public Blesse(Personnage personnage) {
        this.personnage = personnage;
        this.personnage.setEtat(this);
        this.degat = 2;
        this.tour_restant =2;
        this.personnage.setPeutAttaquer(true);
    }

    @Override
    public void action_Tour() {
        tour_restant--;
        if(tour_restant ==0)
            this.personnage.setEtat(new Actif(personnage));
        else
            this.personnage.setPointsDeVie(personnage.getPointsDeVie() - degat);

    }

    public Personnage getPersonnage() {
        return personnage;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

    public int getDegat() {
        return degat;
    }

    public void setDegat(int degat) {
        this.degat = degat;
    }

    public int getTour_restant() {
        return tour_restant;
    }

    public void setTour_restant(int tour_restant) {
        this.tour_restant = tour_restant;
    }
}
