package facade;

import command.*;
import equipe.Equipe;
import outils.Configuration;
import personnage.Guerisseur;
import personnage.Personnage;
import personnage.Sorcier;

import java.util.ArrayList;
import java.util.Scanner;

public class JeuFacade {
    private ArrayList<Equipe> equipes;
    private ArrayList<Personnage> personnages;
    private ArrayList<Command> commandsHistory;
    private ArrayList<Command> commandsRedoHistory;
    public Scanner scanner;

    private int compteur;
    public JeuFacade() {
        equipes = new ArrayList<>();
        personnages = new ArrayList<>();
        commandsHistory = new ArrayList<>();
        commandsRedoHistory = new ArrayList<>();
        Configuration.getInstance().setTailleMaxEquipe(5);
        Configuration.getInstance().setDifficulte(2);
        compteur = 0;
        scanner= new Scanner(System.in);
    }

    public void creerEquipe() {
        Command command = new CreerEquipeCommand(this);
        command.execute();
        commandsHistory.add(command);
    }

    public void supprimerEquipe() {
        Command command = new SupprimerEquipeCommand(this);
        command.execute();
        commandsHistory.add(command);

    }
    public void ameliorerEquipe() {
        Command command = new AmeliorerEquipeCommand(this);
        command.execute();
        commandsHistory.add(command);

    }
    public void ajouterMembreEquipe(){
        Command command = new AjouterMembreEquipeCommand(this);
        command.execute();
        commandsHistory.add(command);
    }
    public void supprimerMembreEquipe(){
        Command command = new SupprimerMembeEquipeCommand(this);
        command.execute();
        commandsHistory.add(command);

    }

    public Equipe trouverEquipeParNom(String nomEquipe) {
        for (Equipe equipe : equipes) {
            if (equipe.getNomEquipe().equals(nomEquipe)) {
                return equipe;
            }
        }
        return null;
    }
    public Personnage trouverPersonnageParNom(String nomPersonnage){
        for(Personnage p : personnages){
            if(p.getNom().equals(nomPersonnage))
                return p;
        }
        return null;
    }
    public void creerPersonnage(){
        Command command = new CreerPersonnageCommand(this);
        command.execute();
        commandsHistory.add(command);
    }
    public void supprimerPersonnage(){
        Command command = new SupprimerPersonnageCommand(this);
        command.execute();
        commandsHistory.add(command);
    }

    public void attaquer(){
        Command command = new AttaqueCommand(this);
        command.execute();
        commandsHistory.add(command);
    }
    public void soin(){
        Command command = new SoinCommand(this);
        command.execute();
        commandsHistory.add(command);
    }
    public void sort(){
        Command command = new SortCommand(this);
        command.execute();
        commandsHistory.add(command);
    }
    public void undo(){
        if(!commandsHistory.isEmpty()){
            Command derniereCommande = commandsHistory.remove(commandsHistory.size()-1);
            commandsRedoHistory.add(derniereCommande);
            derniereCommande.undo();
        }
    }
    public void redo(){
        if(!commandsRedoHistory.isEmpty()){
            Command derniereCommande = commandsRedoHistory.remove(commandsRedoHistory.size()-1);
            commandsHistory.add(derniereCommande);
            derniereCommande.redo();
        }
    }

    public ArrayList<Equipe> getEquipes() {
        return equipes;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public ArrayList<Personnage> getPersonnages() {
        return personnages;
    }
}
