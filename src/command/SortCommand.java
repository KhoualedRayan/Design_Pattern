package command;

import etat.Etat;
import facade.JeuFacade;
import personnage.Guerisseur;
import personnage.Personnage;
import personnage.Sorcier;

public class SortCommand implements Command{
    private JeuFacade jeuFacade;
    private Sorcier sorcier;
    private Personnage maudit;
    private Etat etatAvantSort;
    private Etat etatApresSort;

    public SortCommand(JeuFacade jeuFacade) {
        this.jeuFacade = jeuFacade;
    }

    @Override
    public void execute() {
        for(Personnage p : jeuFacade.getPersonnages()){
            if(p.getClass()== Sorcier.class)
                System.out.print(p.getNom()+";");
        }
        System.out.println();
        System.out.println("Choisir le nom du sorcier");
        String nomSorcier = jeuFacade.scanner.nextLine();
        for(Personnage p : jeuFacade.getPersonnages()){
            System.out.print(p.getNom()+";");
        }
        System.out.println();
        System.out.println("Utiliser un sort sur qui ?");
        String nomMalediction = jeuFacade.scanner.nextLine();
        sorcier = (Sorcier) jeuFacade.trouverPersonnageParNom(nomSorcier);
        maudit = jeuFacade.trouverPersonnageParNom(nomMalediction);
        if(sorcier!=null && maudit!=null){
            etatAvantSort = maudit.getEtat();
            sorcier.sort(maudit);
            System.out.println("Etat de "+maudit.getNom() + " : "+maudit.getEtat());
            etatApresSort = maudit.getEtat();
        }
    }

    @Override
    public void undo() {
        if(sorcier!=null && maudit!=null){
            maudit.setEtat(etatAvantSort);
            System.out.println("Etat réstauré de "+maudit.getNom() + " : "+maudit.getEtat());
        }
    }

    @Override
    public void redo() {
        if(sorcier!=null && maudit!=null){
            maudit.setEtat(etatApresSort);
            System.out.println("Etat de "+maudit.getNom() + " : "+maudit.getEtat());
        }
    }
}
