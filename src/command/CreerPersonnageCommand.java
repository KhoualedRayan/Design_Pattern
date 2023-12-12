package command;

import fabrique.ConstructionGuerisseur;
import fabrique.ConstructionGuerrier;
import fabrique.ConstructionRoi;
import fabrique.ConstructionSorcier;
import facade.JeuFacade;
import personnage.Personnage;

public class CreerPersonnageCommand implements Command{
    private JeuFacade jeuFacade;
    private Personnage perso;
    private ConstructionRoi constructionRoi;
    private ConstructionSorcier constructionSorcier;
    private ConstructionGuerisseur constructionGuerisseur;
    private ConstructionGuerrier constructionGuerrier;

    public CreerPersonnageCommand(JeuFacade jeuFacade) {
        this.jeuFacade = jeuFacade;
        constructionGuerisseur = new ConstructionGuerisseur();
        constructionGuerrier = new ConstructionGuerrier();
        constructionRoi = new ConstructionRoi();
        constructionSorcier = new ConstructionSorcier();
    }

    @Override
    public void execute() {
        System.out.println("Choisir un nom pour votre Personnage");
        String nom = jeuFacade.scanner.nextLine();
        System.out.println("Quel type de personnage voulez vous créer ?");
        System.out.println("1-Roi, 2-Guerrier,3-Sorcier,4-Guerisseur");
        perso = null;
        String action = jeuFacade.scanner.nextLine();
        perso = switch (action) {
            case "1" -> constructionRoi.creerPersonnage();
            case "2" -> constructionGuerrier.creerPersonnage();
            case "3" -> constructionSorcier.creerPersonnage();
            case "4" -> constructionGuerisseur.creerPersonnage();
            default -> perso;
        };
        if (perso != null) {
            perso.setNom(nom);
            jeuFacade.getPersonnages().add(perso);
            System.out.println("Personnage créer : "+perso);
        }
    }

    @Override
    public void undo() {
        if (perso!=null){
            jeuFacade.getPersonnages().remove(perso);
            System.out.println("Personnage supprimé : "+perso);
        }
    }

    @Override
    public void redo() {
        if (perso!=null){
            jeuFacade.getPersonnages().add(perso);
            System.out.println("Personnage créer : "+perso);
        }
    }
}
