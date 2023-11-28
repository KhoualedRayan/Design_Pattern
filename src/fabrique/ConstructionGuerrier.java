package fabrique;

import personnage.Guerrier;
import personnage.Personnage;

public class ConstructionGuerrier implements Construction{
    @Override
    public Personnage creerPersonnage() {
        return new Guerrier();
    }
}
