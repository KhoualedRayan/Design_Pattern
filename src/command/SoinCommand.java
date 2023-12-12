package command;

import facade.JeuFacade;
import personnage.Guerisseur;
import personnage.Personnage;

public class SoinCommand implements Command{
    private JeuFacade jeuFacade;
    private Guerisseur guerisseur;
    private Personnage guerit;
    private int pvAvantSoin;
    private int pvApresSoin;

    public SoinCommand(JeuFacade jeuFacade) {
        this.jeuFacade = jeuFacade;
    }

    @Override
    public void execute() {
        for(Personnage p : jeuFacade.getPersonnages()){
            if(p.getClass()== Guerisseur.class)
                System.out.print(p.getNom()+";");
        }
        System.out.println();
        System.out.println("Choisir le nom du guérisseur");
        String nomGuerisseur = jeuFacade.scanner.nextLine();
        for(Personnage p : jeuFacade.getPersonnages()){
            if(p.getPointsDeVie()< p.getPointsDeVieMax())
                System.out.print(p.getNom()+";");
        }
        System.out.println();
        System.out.println("Choisir le nom du personnage à soigner");
        String nomGuerit = jeuFacade.scanner.nextLine();
        guerisseur = (Guerisseur) jeuFacade.trouverPersonnageParNom(nomGuerisseur);
        guerit = jeuFacade.trouverPersonnageParNom(nomGuerit);
        if(guerisseur!=null && guerit!=null){
            pvAvantSoin = guerit.getPointsDeVie();
            guerisseur.soinPersonnage(guerit);
            System.out.println("PV du personnage après le soin : "+guerit.getPointsDeVie());
            pvApresSoin = guerit.getPointsDeVie();
        }
    }

    @Override
    public void undo() {
        if(guerisseur!=null && guerit!=null){
            guerit.setPointsDeVie(pvAvantSoin);
            System.out.println("Soin annulé, pv : "+guerit.getPointsDeVie());
        }
    }

    @Override
    public void redo() {
        if(guerisseur!=null && guerit!=null){
            guerit.setPointsDeVie(pvApresSoin);
            System.out.println("PV du personnage après le soin : "+guerit.getPointsDeVie());
        }
    }
}
