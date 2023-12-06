package tests;

import arme.Epee;
import etat.Endormi;
import etat.Actif;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import personnage.Guerrier;

class EndormiTest {
    private Epee epeeDuGuerrier;
    private Guerrier guerrier;
    private Endormi endormi;
    @BeforeEach
    void setUp() {
        epeeDuGuerrier = new Epee(4,"Rapière",1.5,3);
        guerrier = new Guerrier(10,1,"Perceval",epeeDuGuerrier,3);
        endormi = new Endormi(guerrier);
    }

    @Test
    void action_Tour() {
        assert(guerrier.getEtat().getClass() == Endormi.class):"Il est pas endormi";
        guerrier.action();
        assert(endormi.getTour_Restant()==1):"Bug tah les fous comment ça il dort pas ???";
        guerrier.action();
        assert(endormi.getTour_Restant()==0):"Tour pas a 0 ???";
        assert(guerrier.getEtat().getClass() == Actif.class):"Il s'est pas reveiller";
    }
}