package tests;

import arme.Epee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import personnage.Guerrier;
import visiteur.DegatVisiteur;
import visiteur.NiveauVisiteur;

import static org.junit.jupiter.api.Assertions.*;

class NiveauVisiteurTest {
    private Guerrier guerrier;
    private Epee epee;
    private NiveauVisiteur niveauVisiteur;
    @BeforeEach
    void setUp() {
        niveauVisiteur= new NiveauVisiteur();
        epee = new Epee(10,"Excalibur",5.0,4);
        guerrier = new Guerrier(10,1,"Lionel",epee,10);
    }

    @Test
    void visitGuerrier() {
        guerrier.accept(niveauVisiteur);
        assert(guerrier.getNiveau() == 2);

    }

    @Test
    void visitRoi() {
    }

    @Test
    void visitSorcier() {
    }

    @Test
    void visitGuerisseur() {
    }
}