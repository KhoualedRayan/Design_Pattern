package tests;

import equipe.Equipe;
import fabrique.ConstructionGuerisseur;
import fabrique.ConstructionGuerrier;
import fabrique.ConstructionRoi;
import fabrique.ConstructionSorcier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import outils.Configuration;
import personnage.Guerisseur;
import personnage.Personnage;

import static org.junit.jupiter.api.Assertions.*;

class ConstructionTest {
    private Equipe equipe;
    private ConstructionRoi constructionRoi;
    private ConstructionSorcier constructionSorcier;
    private ConstructionGuerisseur constructionGuerisseur;
    private ConstructionGuerrier constructionGuerrier;
    @BeforeEach
    void setUp() {
        equipe = new Equipe();
        constructionGuerisseur = new ConstructionGuerisseur();
        constructionGuerrier = new ConstructionGuerrier();
        constructionRoi = new ConstructionRoi();
        constructionSorcier = new ConstructionSorcier();
    }

    @Test
    void creerPersonnage() {
        Configuration.getInstance().setTailleMaxEquipe(5);
        Personnage g = constructionGuerisseur.creerPersonnage();
        g.setNom("Healer");
        equipe.ajouterMembreEquipe(g,constructionGuerrier.creerPersonnage(),constructionRoi.creerPersonnage(),constructionSorcier.creerPersonnage());
        assert (g.getClass() == Guerisseur.class):"Bug fabrique perso sur les classes";
        assert(equipe.getGroupes().size() == 4 ):"Bug création personnage";
    }
}