package command;

import equipe.Equipe;
import facade.JeuFacade;
import personnage.Personnage;

public class SupprimerMembeEquipeCommand implements Command{
    private JeuFacade jeuFacade;
    private Equipe e;
    private Personnage p;

    public SupprimerMembeEquipeCommand(JeuFacade jeuFacade) {
        this.jeuFacade = jeuFacade;
    }

    @Override
    public void execute() {
        System.out.println("Ecrivez le nom de votre équipe.");
        for (Equipe e : jeuFacade.getEquipes())
            System.out.print(e.getNomEquipe()+";");
        System.out.println();
        String nomEquipe = jeuFacade.scanner.nextLine();
        Equipe e = jeuFacade.trouverEquipeParNom(nomEquipe);
        if (e != null) {
            System.out.println("Ecrivez le nom du personnage à supprimer.");
            for (Personnage p : jeuFacade.getPersonnages()){
                if(e.getGroupes().contains(p))
                    System.out.print(p.getNom()+";");
            }
            System.out.println();
            String nomPerso = jeuFacade.scanner.nextLine();
            Personnage p = jeuFacade.trouverPersonnageParNom(nomPerso);
            if (p!=null) {
                e.supprimerMembreEquipe(p);
                System.out.println(e.getNomEquipe() +" : personnage supprimé : "+p.getNom());
            }
        }
    }

    @Override
    public void undo() {
        e.ajouterMembreEquipe(p);
        System.out.println(e.getNomEquipe() +" : personnage ajouté : "+p.getNom());
    }

    @Override
    public void redo() {
        e.supprimerMembreEquipe(p);
        System.out.println(e.getNomEquipe() +" : personnage supprimé : "+p.getNom());
    }
}
