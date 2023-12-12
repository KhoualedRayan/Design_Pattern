package command;

import equipe.Equipe;
import facade.JeuFacade;

import java.util.Scanner;

public class CreerEquipeCommand implements Command{
    private JeuFacade jeuFacade;
    private Equipe e;
    public CreerEquipeCommand(JeuFacade jeuFacade) {
        this.jeuFacade = jeuFacade;
        e = new Equipe();
    }

    @Override
    public void execute() {
        String nom = null;
        e = new Equipe();
        System.out.println("Ecrivez le nom de votre équipe.");
        nom = jeuFacade.getScanner().nextLine();
        e.setNomEquipe(nom);
        jeuFacade.getEquipes().add(e);
        System.out.println("Nouvelle équipe créer: "+ e.getNomEquipe());
    }

    @Override
    public void undo() {
        this.jeuFacade.getEquipes().remove(e);
        System.out.println("Equipe enlevé : "+e.getNomEquipe());
    }

    @Override
    public void redo() {
        jeuFacade.getEquipes().add(e);
        System.out.println("Equipe ré-ajouter: "+ e.getNomEquipe());
    }
}
