package strategie;

import personnage.Personnage;

public class Defensive implements StrategieCombat
{
    @Override
    public void attaquer(int degat, Personnage personnage) {
        personnage.subir((int) ( degat*0.5));
    }

    @Override
    public void subir(int degat, Personnage personnage) {
        personnage.setPointsDeVie(Math.max((int)(personnage.getPointsDeVie() - degat*0.5), 0));
    }

    @Override
    public String toString() {
        return "Defensive";
    }
}
