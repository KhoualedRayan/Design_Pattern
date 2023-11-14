package visiteur;

import personnage.Guerisseur;
import personnage.Guerrier;
import personnage.Roi;
import personnage.Sorcier;

public class NiveauVisiteur implements VisiteurPers{
    @Override
    public void visitGuerrier(Guerrier guerrier) {
        guerrier.setNiveau(guerrier.getNiveau()+1);
        guerrier.setPointsDeVie(guerrier.getPointsDeVie()+2);
        guerrier.setForce(guerrier.getForce()+2);
    }

    @Override
    public void visitRoi(Roi roi) {
        roi.setNiveau(roi.getNiveau()+1);
        roi.setPointsDeVie(roi.getPointsDeVie()+2);
        roi.setForce(roi.getForce()+1);
    }

    @Override
    public void visitSorcier(Sorcier sorcier) {
        sorcier.setNiveau(sorcier.getNiveau()+1);
        sorcier.setPointsDeVie(sorcier.getPointsDeVie()+1);
        sorcier.setIntelligence(sorcier.getIntelligence()+2);
    }

    @Override
    public void visitGuerisseur(Guerisseur guerisseur) {
        guerisseur.setNiveau(guerisseur.getNiveau()+1);
        guerisseur.setPointsDeVie(guerisseur.getPointsDeVie()+1);
        guerisseur.setSagesse(guerisseur.getSagesse()+2);
    }
}
