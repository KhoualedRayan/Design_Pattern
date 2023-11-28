package fabrique;

import personnage.Personnage;
import personnage.Sorcier;

public class ConstructionSorcier implements Construction{
    @Override
    public Personnage creerPersonnage() {
        return new Sorcier();
    }
}
