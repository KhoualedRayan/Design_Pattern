package tests;

import arme.BatonDeSorcier;
import arme.Epee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import personnage.Guerrier;
import personnage.Sorcier;
import strategie.Agressive;
import strategie.Neutre;
import strategie.StrategieCombat;

import static org.junit.jupiter.api.Assertions.*;

class NeutreTest {
    private BatonDeSorcier batonDeSorcier;
    private Epee epeeDuGuerrier;
    private Sorcier sorcier;
    private Guerrier guerrier;
    @BeforeEach
    void setUp() {
        batonDeSorcier = new BatonDeSorcier(3,"Baton de sorcier",2.0,"Feu");
        epeeDuGuerrier = new Epee(4,"Rapière",1.5,3);

        sorcier = new Sorcier(10,1,"Harry Potter",batonDeSorcier,6);
        guerrier = new Guerrier(10,1,"Perceval",epeeDuGuerrier,3);
        StrategieCombat neutre = new Neutre();
        guerrier.setStrategieCombat(neutre);
    }

    @Test
    void attaquer() {
        guerrier.attaquer(sorcier);
        assert (sorcier.getPointsDeVie() ==6):"Bug attaque neutre ne réduit pas les hp";
    }

    @Test
    void subir() {
        guerrier.subir(2);
        assert(guerrier.getPointsDeVie()==8):"Bug subir neutre ne recoit pas assez de dgt";
    }
}