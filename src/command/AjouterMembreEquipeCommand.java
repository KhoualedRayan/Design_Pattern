package command;

import equipe.Equipe;
import facade.JeuFacade;
import personnage.Personnage;

public class AjouterMembreEquipeCommand implements Command{
    private JeuFacade jeuFacade;
    private Equipe e;
    private Personnage p;


    public AjouterMembreEquipeCommand(JeuFacade jeuFacade) {
        this.jeuFacade = jeuFacade;
    }

    @Override
    public void execute() {
        System.out.println("Ecrivez le nom de votre équipe à laquelle ajouter un personnage");
        for (Equipe e : jeuFacade.getEquipes())
            System.out.print(e.getNomEquipe()+";");
        System.out.println();
        String nomEquipe = jeuFacade.scanner.nextLine();
        e = jeuFacade.trouverEquipeParNom(nomEquipe);
        if (e != null) {
            System.out.println("Ecrivez le nom du personnage à rajouter.");
            for (Personnage p : jeuFacade.getPersonnages()){
                if(!e.getGroupes().contains(p))
                    System.out.print(p.getNom()+";");
            }
            System.out.println();
            String nomPerso = jeuFacade.scanner.nextLine();
            p = jeuFacade.trouverPersonnageParNom(nomPerso);
            if(p!=null) {
                e.ajouterMembreEquipe(p);
                System.out.println(e.getNomEquipe() +" : personnage ajouté : "+p.getNom());
            }
        }
    }

    @Override
    public void undo() {
        e.supprimerMembreEquipe(p);
        System.out.println(e.getNomEquipe() +" : personnage supprimé : "+p.getNom());
    }

    @Override
    public void redo() {
        e.ajouterMembreEquipe(p);
        System.out.println(e.getNomEquipe() +" : personnage ajouté : "+p.getNom());
    }
}
