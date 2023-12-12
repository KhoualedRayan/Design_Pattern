package strategie;

import personnage.Personnage;

public class Agressive implements StrategieCombat{
    @Override
    public void attaquer(int degat, Personnage personnage) {
        personnage.subir(degat *2);
    }

    @Override
    public void subir(int degat, Personnage personnage) {
        personnage.setPointsDeVie(Math.max(personnage.getPointsDeVie() - degat*2, 0));
    }

    @Override
    public String toString() {
        return "Agressive";
    }
}
