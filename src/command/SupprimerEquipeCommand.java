package command;

import equipe.Equipe;
import facade.JeuFacade;

public class SupprimerEquipeCommand implements Command{
    private JeuFacade jeuFacade;
    private Equipe e;

    public SupprimerEquipeCommand(JeuFacade jeuFacade) {
        this.jeuFacade = jeuFacade;
        e = new Equipe();
    }

    @Override
    public void execute() {
        System.out.println("Ecrivez le nom de l'équipe à supprimer");
        for (Equipe e : jeuFacade.getEquipes())
            System.out.print(e.getNomEquipe()+";");
        System.out.println();
        String nomEquipe = jeuFacade.getScanner().nextLine();
        Equipe e = jeuFacade.trouverEquipeParNom(nomEquipe);
        if (e != null) {
            jeuFacade.getEquipes().remove(e);
            System.out.println("Equipe supprimé : "+e.getNomEquipe());
        }
    }

    @Override
    public void undo() {
        jeuFacade.getEquipes().add(e);
        System.out.println("Equipe ré-ajouter: "+ e.getNomEquipe());
    }

    @Override
    public void redo() {
        this.jeuFacade.getEquipes().remove(e);
        System.out.println("Equipe enlevé : "+e.getNomEquipe());
    }
}
