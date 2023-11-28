package fabrique;

import personnage.Personnage;
import personnage.Roi;

public class ConstructionRoi implements Construction {
    @Override
    public Personnage creerPersonnage() {
        return new Roi();
    }
}
