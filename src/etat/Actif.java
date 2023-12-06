package etat;

import personnage.Personnage;

public class Actif implements Etat{
    private Personnage personnage;

    public Actif(Personnage personnage) {
        this.personnage = personnage;
        this.personnage.setPeutAttaquer(true);
    }

    @Override
    public void action_Tour() {
    }

    public Personnage getPersonnage() {
        return personnage;
    }


    @Override
    public String toString() {
        return "Reveiller{" +
                "personnage=" + personnage +
                '}';
    }
}
