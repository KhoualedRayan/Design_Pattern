package tests;

import arme.BaguetteMagique;
import arme.Epee;
import etat.Blesse;
import etat.Actif;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import personnage.Guerisseur;
import personnage.Guerrier;

class BlesseTest {
    private Epee epeeDuGuerrier;
    private Guerrier guerrier;
    private Blesse blesse;

    @BeforeEach
    void setUp() {
        epeeDuGuerrier = new Epee(4,"Rapière",1.5,3);
        guerrier = new Guerrier(10,1,"Perceval",epeeDuGuerrier,3);
        blesse = new Blesse(guerrier);
    }

    @Test
    void action_Tour() {
        assert(guerrier.getEtat().getClass() == Blesse.class):"Il est pas blessé";
        guerrier.action();
        assert(blesse.getTour_restant()==1):"Bug tah les fous comment ça il est pas blessé ???";
        assert(guerrier.getPointsDeVie()==8):"Perd pas le hp en état blessé";
        guerrier.action();
        assert(blesse.getTour_restant()==0):"Tour pas a 0 ???";
        assert(guerrier.getEtat().getClass() == Actif.class):"Il s'est pas reveiller";
        BaguetteMagique baguetteMagique = new BaguetteMagique(3,"Baguette magique",2.0,5);

        Guerisseur guerisseur = new Guerisseur(3,1,"Merlin",baguetteMagique,7);
        guerisseur.soinPersonnage(guerrier);
        assert(guerrier.getPointsDeVie()==10):"Heal bug";

    }

}