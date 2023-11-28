package etat;

import personnage.Personnage;

public class Endormi implements Etat{
    private int tour_Restant;
    private Personnage personnage;

    public Endormi(Personnage personnage) {
        this.personnage = personnage;
         tour_Restant = 2;
    }

    @Override
    public void action_Tour() {
        tour_Restant--;
        if(tour_Restant ==0){
            this.personnage.setEtat(new Reveiller(personnage));
        }
    }

    public int getTour_Restant() {
        return tour_Restant;
    }

    public void setTour_Restant(int tour_Restant) {
        this.tour_Restant = tour_Restant;
    }

    public Personnage getPersonnage() {
        return personnage;
    }


    @Override
    public String toString() {
        return "Endormi{" +
                "tour_Restant=" + tour_Restant +
                ", personnage=" + personnage +
                '}';
    }
}
