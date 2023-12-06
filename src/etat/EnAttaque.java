package etat;

import personnage.Personnage;

public class EnAttaque implements Etat{
    private Personnage p;
    public EnAttaque(Personnage p) {
        this.p = p;
        this.p.setEtat(this);
        this.p.setPeutAttaquer(true);
    }

    @Override
    public void action_Tour() {
        this.p.setEtat(new Actif(p));
    }

    public Personnage getP() {
        return p;
    }

    public void setP(Personnage p) {
        this.p = p;
    }

}
