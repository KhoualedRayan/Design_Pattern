package etat;

import personnage.Personnage;

public class EnAttaque implements Etat{
    private Personnage p;

    public EnAttaque(Personnage p) {
        this.p = p;
    }

    @Override
    public void action_Tour() {

    }
}
