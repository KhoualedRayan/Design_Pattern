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


    public int getTour_restant() {
        return tour_restant;
    }

    @Override
    public String toString() {
        return "Blesse{" +
                "personnage=" + personnage +
                ", degat=" + degat +
                ", tour_restant=" + tour_restant +
                '}';
    }
}
