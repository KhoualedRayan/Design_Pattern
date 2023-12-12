package command;

import facade.JeuFacade;
import personnage.Personnage;

public class SupprimerPersonnageCommand implements Command{
    private JeuFacade jeuFacade;
    private Personnage perso;

    public SupprimerPersonnageCommand(JeuFacade jeuFacade) {
        this.jeuFacade = jeuFacade;
    }

    @Override
    public void execute() {
        for(Personnage p : jeuFacade.getPersonnages()){
            System.out.print(p.getNom()+";");
        }
        System.out.println();
        System.out.println("Choisir le nom du personnage à supprimer");
        String nom = jeuFacade.scanner.nextLine();
        perso = jeuFacade.trouverPersonnageParNom(nom);
        if (perso != null) {
            jeuFacade.getPersonnages().remove(perso);
            System.out.println("Personnage supprimé : "+ perso.getNom());
        }
    }

    @Override
    public void undo() {
        if (perso != null) {
            jeuFacade.getPersonnages().add(perso);
            System.out.println("Personnage ajouté : "+ perso.getNom());
        }
    }

    @Override
    public void redo() {
        if (perso != null) {
            jeuFacade.getPersonnages().remove(perso);
            System.out.println("Personnage supprimé : "+ perso.getNom());
        }
    }
}
