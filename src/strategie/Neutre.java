package strategie;

import personnage.Personnage;

public class Neutre implements StrategieCombat{
    @Override
    public void attaquer(int degat, Personnage personnage) {
        personnage.subir(degat);
    }

    @Override
    public void subir(int degat, Personnage personnage) {
        personnage.setPointsDeVie(Math.max(personnage.getPointsDeVie() - degat, 0));
    }

    @Override
    public String toString() {
        return "Neutre";
    }
}
