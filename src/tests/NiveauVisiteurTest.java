package tests;

import arme.BaguetteMagique;
import arme.BatonDeSorcier;
import arme.Epee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import personnage.Guerisseur;
import personnage.Guerrier;
import personnage.Sorcier;
import visiteur.DegatVisiteur;
import visiteur.NiveauVisiteur;

import static org.junit.jupiter.api.Assertions.*;

class NiveauVisiteurTest {
    private Guerrier guerrier;
    private Sorcier sorcier;
    private Guerisseur guerisseur;
    private Epee epee;
    private BatonDeSorcier batonDeSorcier;
    private BaguetteMagique baguetteMagique;
    private NiveauVisiteur niveauVisiteur;
    @BeforeEach
    void setUp() {
        niveauVisiteur= new NiveauVisiteur();
        BaguetteMagique baguetteMagique = new BaguetteMagique(3,"Baguette magique",2.0,5);
        BatonDeSorcier batonDeSorcier = new BatonDeSorcier(5,"Baton de sorcier",2.0,"Feu");
        epee = new Epee(10,"Excalibur",5.0,4);
        sorcier = new Sorcier(4,1,"Harry Potter",batonDeSorcier,6);
        guerisseur = new Guerisseur(3,1,"Merlin",baguetteMagique,7);
        guerrier = new Guerrier(10,1,"Lionel",epee,10);
    }

    @Test
    void visitGuerrier() {
        guerrier.accept(niveauVisiteur);
        assert(guerrier.getNiveau() == 2):"Augmentation du niveau suite au lvl up du visiteur du guerrier bug !";
        assert(guerrier.getForce() == 12):"Augmentation de la force suite au lvl up du visiteur du guerrier bug !";
        assert(guerrier.getPointsDeVie() == 12):"Augmentation des pv suite au lvl du guerrier bug !";

    }

    @Test
    void visitRoi() {
    }

    @Test
    void visitSorcier() {
        sorcier.accept(niveauVisiteur);
        assert(sorcier.getNiveau() == 2):"Augmentation du niveau suite au lvl up du visiteur du sorcier bug !";
        assert(sorcier.getIntelligence() == 8):"Augmentation de l'intelligence suite au lvl up du visiteur du sorcier bug !";
        assert(sorcier.getPointsDeVie() == 5):"Augmentation des pv suite au lvl du sorcier bug !";
    }

    @Test
    void visitGuerisseur() {
        guerisseur.accept(niveauVisiteur);
        assert(guerisseur.getNiveau() == 2):"Augmentation du niveau suite au lvl up du visiteur du guerisseur bug !";
        assert(guerisseur.getSagesse() == 9):"Augmentation de la sagesse suite au lvl up du visiteur du guerisseur bug !";
        assert(guerisseur.getPointsDeVie() == 4):"Augmentation des pv suite au lvl du guerisseur bug !";
    }
}