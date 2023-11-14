package visiteur;

import personnage.Guerisseur;
import personnage.Guerrier;
import personnage.Roi;
import personnage.Sorcier;

public class NiveauVisiteur implements VisiteurPers{
    @Override
    public void visitGuerrier(Guerrier guerrier) {
        guerrier.setNiveau(guerrier.getNiveau()+1);
    }

    @Override
    public void visitRoi(Roi roi) {
        roi.setNiveau(roi.getNiveau()+1);

    }

    @Override
    public void visitSorcier(Sorcier sorcier) {
        sorcier.setNiveau(sorcier.getNiveau()+1);

    }

    @Override
    public void visitGuerisseur(Guerisseur guerisseur) {
        guerisseur.setNiveau(guerisseur.getNiveau()+1);

    }
}
