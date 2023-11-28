package etat;

import personnage.Personnage;

public class Blesse implements Etat{
    private Personnage personnage;

    public Blesse(Personnage personnage) {
        this.personnage = personnage;
    }

    @Override
    public void action_Tour() {

    }

}
