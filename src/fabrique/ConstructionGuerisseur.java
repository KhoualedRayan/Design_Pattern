package fabrique;

import personnage.Guerisseur;
import personnage.Personnage;

public class ConstructionGuerisseur implements Construction{
    @Override
    public Personnage creerPersonnage() {
        return new Guerisseur();
    }
}
