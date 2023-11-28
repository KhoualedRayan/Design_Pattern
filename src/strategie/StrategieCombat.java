package strategie;

import personnage.Personnage;

public interface StrategieCombat {
    public void attaquer(int degat, Personnage personnage);
    public void subir(int degat, Personnage personnage);
}
