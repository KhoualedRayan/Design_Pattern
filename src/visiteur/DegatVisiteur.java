package visiteur;

import personnage.Guerisseur;
import personnage.Guerrier;
import personnage.Roi;
import personnage.Sorcier;

public class DegatVisiteur implements VisiteurPers{
    @Override
    public void visitGuerrier(Guerrier guerrier) {
        guerrier.getArme().setDegat(guerrier.getArme().getDegat()+1);
    }

    @Override
    public void visitRoi(Roi roi) {
        roi.getArme().setDegat(roi.getArme().getDegat()+1);

    }

    @Override
    public void visitSorcier(Sorcier sorcier) {
        sorcier.getArme().setDegat(sorcier.getArme().getDegat()+1);

    }

    @Override
    public void visitGuerisseur(Guerisseur guerisseur) {
        guerisseur.getArme().setDegat(guerisseur.getArme().getDegat()+1);

    }

}
