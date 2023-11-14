package visiteur;

import personnage.Guerisseur;
import personnage.Guerrier;
import personnage.Roi;
import personnage.Sorcier;

public interface VisiteurPers {
    public void visitGuerrier(Guerrier guerrier);
    public void visitRoi(Roi roi);
    public void visitSorcier(Sorcier sorcier);
    public void visitGuerisseur(Guerisseur guerisseur);


}
