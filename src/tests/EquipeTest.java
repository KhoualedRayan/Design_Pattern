package tests;

import arme.BaguetteMagique;
import arme.BatonDeSorcier;
import arme.Epee;
import equipe.Equipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import personnage.*;
import visiteur.DegatVisiteur;
import visiteur.NiveauVisiteur;

import static org.junit.jupiter.api.Assertions.*;

class EquipeTest {
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
         degatVisiteur = new DegatVisiteur();
         niveauVisiteur = new NiveauVisiteur();
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
    void accept() {
        equipe.ajouterMembreEquipe(sorcier,roi,guerisseur);
        equipe.accept(niveauVisiteur);
        equipe.accept(degatVisiteur);
        assert(sorcier.getNiveau() == 2):"Bug sur NiveauVisiteur dans le groupe";
        assert(roi.getNiveau() == 2):"Bug sur NiveauVisiteur dans le groupe";
        assert(guerisseur.getNiveau() == 2):"Bug sur NiveauVisiteur dans le groupe";
        equipe.ajouterMembreEquipe(guerrier);
        assert(guerrier.getNiveau() == 1):"Bug sur NiveauVisiteur dans le groupe apres ajout ";

        assert(sorcier.getArme().getDegat() ==6):"Bug sur DegatVisiteur dans le groupe";
        assert(roi.getArme().getDegat() ==6):"Bug sur DegatVisiteur dans le groupe";
        assert(guerisseur.getArme().getDegat() ==4):"Bug sur DegatVisiteur dans le groupe";
        assert(guerrier.getArme().getDegat() ==4):"Bug sur DegatVisiteur dans le groupe";
    }

    @Test
    void ajouterMembreEquipe() {
        equipe.ajouterMembreEquipe(sorcier,roi,guerisseur);
        assert(equipe.getGroupes().size() == 3):"Bug sur l'ajout de membres dans une équipe";
        assert(equipe.getGroupes().contains(sorcier)):"Bug sur l'ajout de membres dans une equipe";
        assert(equipe.getGroupes().contains(roi)):"Bug sur l'ajout de membres dans une equipe";
        assert(equipe.getGroupes().contains(guerisseur)):"Bug sur l'ajout de membres dans une equipe";
    }

    @Test
    void supprimerMembreEquipe() {
        equipe.ajouterMembreEquipe(sorcier,roi,guerisseur);
        equipe.supprimerMembreEquipe(sorcier,guerisseur);
        assert(!equipe.getGroupes().contains(sorcier)):"Bug sur la suppresion d'un membre d'un groupe";
        assert(!equipe.getGroupes().contains(guerisseur)):"Bug sur la suppresion d'un membre d'un groupe";
        assert(equipe.getGroupes().contains(roi)):"Bug sur la suppresion d'un membre d'un groupe, supprime trop de membres";

    }
}