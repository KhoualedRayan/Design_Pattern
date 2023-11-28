package etat;

import personnage.Personnage;

public class Reveiller implements Etat{
    private Personnage personnage;

    public Reveiller(Personnage personnage) {
        this.personnage = personnage;
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
