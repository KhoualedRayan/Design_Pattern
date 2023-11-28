package tests;

import arme.BaguetteMagique;
import arme.BatonDeSorcier;
import arme.Epee;
import equipe.Equipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import outils.Configuration;
import personnage.Guerisseur;
import personnage.Guerrier;
import personnage.Roi;
import personnage.Sorcier;
import visiteur.DegatVisiteur;
import visiteur.NiveauVisiteur;

import static org.junit.jupiter.api.Assertions.*;

class ConfigurationTest {
    private DegatVisiteur degatVisiteur;
    private NiveauVisiteur niveauVisiteur;
    private BaguetteMagique baguetteMagique;
    private BatonDeSorcier batonDeSorcier;
    private Epee epeeDuRoi;
    private Epee epeeDuGuerrier;
    private Sorcier sorcier;
    private Roi roi;
    private Guerisseur guerisseur;
    private Guerrier guerrier;
    private Equipe equipe;

    @BeforeEach
    void setUp() {
        Configuration.getInstance().setDifficulte(3);
        Configuration.getInstance().setTailleMaxEquipe(3);
        equipe = new Equipe();
        baguetteMagique = new BaguetteMagique(3,"Baguette magique",2.0,5);
        batonDeSorcier = new BatonDeSorcier(5,"Baton de sorcier",2.0,"Feu");
        epeeDuRoi = new Epee(5,"Excalibur",3.0,4);
        epeeDuGuerrier = new Epee(4,"Rapière",1.5,3);

        sorcier = new Sorcier(4,1,"Harry Potter",batonDeSorcier,6);
        roi = new Roi(6,1,"Arthur",epeeDuRoi,6,"Bretagne");
        guerrier = new Guerrier(8,1,"Perceval",epeeDuGuerrier,3);
        guerisseur = new Guerisseur(3,1,"Merlin",baguetteMagique,7);
    }

    @Test
    void getTailleMaxEquipe() {
        assert(Configuration.getInstance().getTailleMaxEquipe()==3):"Erreur taille max equipe";
        equipe.ajouterMembreEquipe(sorcier,roi,guerisseur,guerrier);
        assert (equipe.getGroupes().get(2).equals(guerisseur)):"Erreur taille max lors de l'ajout de membre";
        assert (!equipe.getGroupes().contains(guerrier)):"Erreur taille max lors de l'ajout de membre en trop";
    }

    @Test
    void getDifficulte() {
        assert(Configuration.getInstance().getDifficulte()==3):"Erreur Difficulé";
    }
}