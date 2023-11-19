package tests;

import arme.BaguetteMagique;
import arme.BatonDeSorcier;
import arme.Epee;
import equipe.Equipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import personnage.Guerisseur;
import personnage.Guerrier;
import personnage.Roi;
import personnage.Sorcier;
import visiteur.CompteurSorcierVisiteur;
import visiteur.DegatVisiteur;
import visiteur.NiveauVisiteur;

import static org.junit.jupiter.api.Assertions.*;

class CompteurSorcierVisiteurTest {
    private Equipe equipe;
    private CompteurSorcierVisiteur compteurSorcierVisiteur;
    private BaguetteMagique baguetteMagique;
    private BatonDeSorcier batonDeSorcier;
    private Epee epeeDuRoi;
    private Epee epeeDuGuerrier;
    private Sorcier sorcier;
    private Sorcier sorcier2;
    private Roi roi;
    private Guerisseur guerisseur;
    private Guerrier guerrier;



    @BeforeEach
    void setUp() {
        equipe = new Equipe();
        compteurSorcierVisiteur = new CompteurSorcierVisiteur();

        baguetteMagique = new BaguetteMagique(3,"Baguette magique",2.0,5);
        batonDeSorcier = new BatonDeSorcier(5,"Baton de sorcier",2.0,"Feu");
        epeeDuRoi = new Epee(5,"Excalibur",3.0,4);
        epeeDuGuerrier = new Epee(4,"Rapière",1.5,3);

        sorcier = new Sorcier(4,1,"Harry Potter",batonDeSorcier,6);
        sorcier2 = new Sorcier(3,1,"Ron Wesley",batonDeSorcier,5);
        roi = new Roi(6,1,"Arthur",epeeDuRoi,6,"Bretagne");
        guerrier = new Guerrier(8,1,"Perceval",epeeDuGuerrier,3);
        guerisseur = new Guerisseur(3,1,"Merlin",baguetteMagique,7);
        equipe.ajouterMembreEquipe(sorcier,guerisseur,guerrier,roi);

    }

    @Test
    void visitEquipe() {
        int compteur = compteurSorcierVisiteur.visitEquipe(equipe);
        assert(compteur == 1):"Compteur Sorcier Visiteur bug";
        equipe.ajouterMembreEquipe(sorcier2);
        int compteur2 = compteurSorcierVisiteur.visitEquipe(equipe);
        assert(compteur2 == 2):"Compteur Sorcier Visiteur bug";

    }
}