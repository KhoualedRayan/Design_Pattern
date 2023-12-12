package command;

import facade.JeuFacade;
import personnage.Personnage;
import strategie.Agressive;
import strategie.Defensive;
import strategie.Neutre;
import strategie.StrategieCombat;

public class ChangementStrategieCombatCommand implements Command{
    private JeuFacade jeuFacade;
    private Personnage p;
    private StrategieCombat stratAvant;
    private StrategieCombat stratApres;

    public ChangementStrategieCombatCommand(JeuFacade jeuFacade) {
        this.jeuFacade = jeuFacade;
    }

    @Override
    public void execute() {
        for(Personnage p : jeuFacade.getPersonnages()){
            System.out.print(p.getNom()+";");
        }
        System.out.println();
        System.out.println("Choisir le nom du personnage à changer la stratégie");
        String nomPerso = jeuFacade.scanner.nextLine();
        p = jeuFacade.trouverPersonnageParNom(nomPerso);
        if(p!=null){
            StrategieCombat strategieCombat;
            System.out.println("Choisir la stratégie à adopter(1,2,3)");
            System.out.println("1-Attaque, 2-Neutre, 3-Défensive, Autre pour annuler");
            stratAvant = p.getStrategieCombat();
            String stratChoix = jeuFacade.scanner.nextLine();
            switch (stratChoix){
                case "1":
                    strategieCombat = new Agressive();
                    break;
                case "2":
                    strategieCombat = new Neutre();
                    break;
                case "3":
                    strategieCombat = new Defensive();
                    break;
                default:
                    return;
            }
            p.setStrategieCombat(strategieCombat);
            System.out.println("Nouvelle stratégie de combat de "+p.getNom() +" : "+p.getStrategieCombat());
            stratApres = p.getStrategieCombat();
        }else {
            System.out.println("Perso inexistant");
        }
    }

    @Override
    public void undo() {
        if(p!=null){
            p.setStrategieCombat(stratAvant);
            System.out.println("Ancienne stratégie de combat restauré de "+p.getNom() +" : "+p.getStrategieCombat());
        }
    }

    @Override
    public void redo() {
        if(p!=null){
            p.setStrategieCombat(stratApres);
            System.out.println("Nouvelle stratégie de combat restauré de "+p.getNom() +" : "+p.getStrategieCombat());
        }
    }
}
