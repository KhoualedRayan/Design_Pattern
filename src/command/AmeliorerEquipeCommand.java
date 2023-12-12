package command;

import equipe.Equipe;
import equipe.Groupe;
import facade.JeuFacade;
import personnage.Personnage;
import visiteur.DegatVisiteur;
import visiteur.NiveauVisiteur;

public class AmeliorerEquipeCommand implements Command{
    private JeuFacade jeuFacade;
    private Equipe e;
    private String visiteur;

    public AmeliorerEquipeCommand(JeuFacade jeuFacade) {
        this.jeuFacade = jeuFacade;
        this.e = new Equipe();
    }

    @Override
    public void execute() {
        System.out.println("Ecrivez le nom de l'équipe à améliorer");
        for (Equipe e : jeuFacade.getEquipes())
            System.out.print(e.getNomEquipe()+";");
        System.out.println();
        String nomEquipe = jeuFacade.scanner.nextLine();
        e = jeuFacade.trouverEquipeParNom(nomEquipe);
        if(e!=null){
            System.out.println("1-Niveau 2-Degats");
            visiteur = jeuFacade.scanner.nextLine();
            switch (visiteur){
                case "1":
                    e.accept(new NiveauVisiteur());
                    break;
                case "2":
                    e.accept(new DegatVisiteur());
                    break;
            }
            System.out.println(e);
        }
    }

    @Override
    public void undo() {
        switch (visiteur){
            case "1":
                for (Groupe g :  e.getGroupes()){
                    Personnage p = (Personnage) g;
                    p.setNiveau(p.getNiveau()-1);
                }
                break;
            case "2":
                for (Groupe g :  e.getGroupes()){
                    Personnage p = (Personnage) g;
                    p.getArme().setDegat(p.getArme().getDegat()-1);
                }
                break;
        }
        System.out.println(e);
    }

    @Override
    public void redo() {
        switch (visiteur){
            case "1":
                e.accept(new NiveauVisiteur());
                break;
            case "2":
                e.accept(new DegatVisiteur());
                break;
        }
        System.out.println(e);
    }
}
