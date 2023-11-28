package strategie;

import personnage.Personnage;

public interface StrategieCombat {
    void attaquer(int degat, Personnage personnage);
    void subir(int degat, Personnage personnage);
}
