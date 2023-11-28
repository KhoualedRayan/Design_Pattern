package tests;

import arme.Epee;
import etat.Endormi;
import etat.Etat;
import fabrique.ConstructionGuerrier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import personnage.Guerrier;
import personnage.Personnage;
import personnage.Sorcier;

import static org.junit.jupiter.api.Assertions.*;

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
        guerrier.getEtat().action_Tour();
        System.out.println(endormi.toString());
    }
}