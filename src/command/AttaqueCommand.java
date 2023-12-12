package command;

import facade.JeuFacade;
import personnage.Personnage;

public class AttaqueCommand implements Command{
    private JeuFacade jeuFacade;
    private Personnage attaquant;
    private Personnage subissant;
    private int pvAvantAttaque;
    private int pvApresAttaque;

    public AttaqueCommand(JeuFacade jeuFacade) {
        this.jeuFacade = jeuFacade;
    }

    @Override
    public void execute() {
        for(Personnage p : jeuFacade.getPersonnages()){
            System.out.print(p.getNom()+";");
        }
        System.out.println();
        System.out.println("Choisir le nom du personnage attaquant");
        String nomAttaquant = jeuFacade.scanner.nextLine();
        System.out.println("Choisir le nom du personnage attaqué");
        String nomSubissant = jeuFacade.scanner.nextLine();
        attaquant = jeuFacade.trouverPersonnageParNom(nomAttaquant);
        subissant = jeuFacade.trouverPersonnageParNom(nomSubissant);
        if(attaquant!=null && subissant!=null){
            pvAvantAttaque = subissant.getPointsDeVie();
            attaquant.attaquer(subissant);
            System.out.println("PV du personnage après l'attaque : "+subissant.getPointsDeVie());
            pvApresAttaque = subissant.getPointsDeVie();
        }
    }

    @Override
    public void undo() {
        if(attaquant!=null && subissant!=null){
            subissant.setPointsDeVie(pvAvantAttaque);
            System.out.println("Attaque annulé, pv restauré : "+subissant.getPointsDeVie());
        }
    }

    @Override
    public void redo() {
        if(attaquant!=null && subissant!=null){
            subissant.setPointsDeVie(pvApresAttaque);
            System.out.println("Attaque , pv après l'attaque : "+subissant.getPointsDeVie());
        }
    }
}
