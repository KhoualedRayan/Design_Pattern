package tests;

import arme.Epee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import personnage.Guerrier;
import personnage.Roi;
import visiteur.DegatVisiteur;
import visiteur.NiveauVisiteur;

import static org.junit.jupiter.api.Assertions.*;

class DegatVisiteurTest {
    private Roi roi;
    private Epee epee;
    private DegatVisiteur degatVisiteur;
    @BeforeEach
    void setUp() {
        degatVisiteur= new DegatVisiteur();
        epee = new Epee(10,"Excalibur",5.0,4);
        roi = new Roi(10,1,"Lionel",epee,10,"Bretagne");
    }

    @Test
    void visitGuerrier() {
    }

    @Test
    void visitRoi() {
        roi.accept(degatVisiteur);
        assert(roi.getArme().getDegat() == 11);
    }

    @Test
    void visitSorcier() {
    }

    @Test
    void visitGuerisseur() {
    }
}