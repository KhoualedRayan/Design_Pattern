package facade;

import equipe.Equipe;
import fabrique.ConstructionGuerisseur;
import fabrique.ConstructionGuerrier;
import fabrique.ConstructionRoi;
import fabrique.ConstructionSorcier;
import outils.Configuration;
import personnage.Guerisseur;
import personnage.Personnage;
import personnage.Sorcier;
import visiteur.DegatVisiteur;
import visiteur.NiveauVisiteur;

import java.util.ArrayList;
import java.util.Scanner;

public class JeuFacade {
    public ArrayList<Equipe> equipes;
    public ArrayList<Personnage> personnages;
    public Scanner scanner;
    private ConstructionRoi constructionRoi;
    private ConstructionSorcier constructionSorcier;
    private ConstructionGuerisseur constructionGuerisseur;
    private ConstructionGuerrier constructionGuerrier;

    private int compteur;
    public JeuFacade() {
        equipes = new ArrayList<>();
        personnages = new ArrayList<>();
        Configuration.getInstance().setTailleMaxEquipe(5);
        Configuration.getInstance().setDifficulte(2);
        compteur = 0;
        scanner= new Scanner(System.in);
        constructionGuerisseur = new ConstructionGuerisseur();
        constructionGuerrier = new ConstructionGuerrier();
        constructionRoi = new ConstructionRoi();
        constructionSorcier = new ConstructionSorcier();
    }

    public void creerEquipe() {
        String nom = null;
        Equipe e = new Equipe();
        System.out.println("Ecrivez le nom de votre équipe.");
        nom = scanner.nextLine();
        e.setNomEquipe(nom);
        equipes.add(e);
        System.out.println("Nouvelle équipe créer: "+ e.getNomEquipe());
    }

    public void supprimerEquipe() {
        System.out.println("Ecrivez le nom de l'équipe à supprimer");
        for (Equipe e : equipes)
            System.out.print(e.getNomEquipe()+";");
        System.out.println();
        String nomEquipe = scanner.nextLine();
        Equipe e = trouverEquipeParNom(nomEquipe);
        if (e != null) {
            equipes.remove(e);
            System.out.println("Equipe supprimé : "+e.getNomEquipe());
        }
    }
    public void ameliorerEquipe() {
        System.out.println("Ecrivez le nom de l'équipe à améliorer");
        for (Equipe e : equipes)
            System.out.print(e.getNomEquipe()+";");
        System.out.println();
        String nomEquipe = scanner.nextLine();
        Equipe e = trouverEquipeParNom(nomEquipe);
        if(e!=null){
            System.out.println("1-Niveau 2-Degats");
            String visiteur = scanner.nextLine();
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
    public void ajouterMembreEquipe(){
        System.out.println("Ecrivez le nom de votre équipe à laquelle ajouter un personnage");
        for (Equipe e : equipes)
            System.out.print(e.getNomEquipe()+";");
        System.out.println();
        String nomEquipe = scanner.nextLine();
        Equipe e = trouverEquipeParNom(nomEquipe);
        if (e != null) {
            System.out.println("Ecrivez le nom du personnage à rajouter.");
            for (Personnage p : personnages){
                if(!e.getGroupes().contains(p))
                    System.out.print(p.getNom()+";");
            }
            System.out.println();
            String nomPerso = scanner.nextLine();
            Personnage p = trouverPersonnageParNom(nomPerso);
            if(p!=null) {
                e.ajouterMembreEquipe(p);
                System.out.println(e.getNomEquipe() +" : personnage ajouté : "+p.getNom());
            }
        }
    }
    public void supprimerMembreEquipe(){
        System.out.println("Ecrivez le nom de votre équipe.");
        for (Equipe e : equipes)
            System.out.print(e.getNomEquipe()+";");
        System.out.println();
        String nomEquipe = scanner.nextLine();
        Equipe e = trouverEquipeParNom(nomEquipe);
        if (e != null) {
            System.out.println("Ecrivez le nom du personnage à supprimer.");
            for (Personnage p : personnages){
                if(e.getGroupes().contains(p))
                    System.out.print(p.getNom()+";");
            }
            System.out.println();
            String nomPerso = scanner.nextLine();
            Personnage p = trouverPersonnageParNom(nomPerso);
            if (p!=null) {
                e.supprimerMembreEquipe(p);
                System.out.println(e.getNomEquipe() +" : personnage supprimé : "+p.getNom());
            }
        }
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
        System.out.println("Choisir un nom pour votre Personnage");
        String nom = scanner.nextLine();
        System.out.println("Quel type de personnage voulez vous créer ?");
        System.out.println("1-Roi, 2-Guerrier,3-Sorcier,4-Guerisseur");
        Personnage perso = null;
        String action = scanner.nextLine();
        perso = switch (action) {
            case "1" -> constructionRoi.creerPersonnage();
            case "2" -> constructionGuerrier.creerPersonnage();
            case "3" -> constructionSorcier.creerPersonnage();
            case "4" -> constructionGuerisseur.creerPersonnage();
            default -> perso;
        };
        if (perso != null) {
            perso.setNom(nom);
            personnages.add(perso);
        }
        System.out.println(perso != null ? perso.toString() : null);
    }
    public void supprimerPersonnage(){
        for(Personnage p : personnages){
            System.out.print(p.getNom()+";");
        }
        System.out.println();
        System.out.println("Choisir le nom du personnage à supprimer");
        String nom = scanner.nextLine();
        Personnage perso = trouverPersonnageParNom(nom);
        if (perso != null) {
            perso.setNom(nom);
            personnages.remove(perso);
            System.out.println("Personnage supprimé : "+ perso.getNom());
        }
    }

    public void attaquer(){
        for(Personnage p : personnages){
            System.out.print(p.getNom()+";");
        }
        System.out.println();
        System.out.println("Choisir le nom du personnage attaquant");
        String nomAttaquant = scanner.nextLine();
        System.out.println("Choisir le nom du personnage attaqué");
        String nomSubissant = scanner.nextLine();
        Personnage attaquant = trouverPersonnageParNom(nomAttaquant);
        Personnage subissant = trouverPersonnageParNom(nomSubissant);
        if(attaquant!=null && subissant!=null){
            attaquant.attaquer(subissant);
            System.out.println("PV du personnage après l'attaque : "+subissant.getPointsDeVie());
        }
    }
    public void soin(){
        for(Personnage p : personnages){
            if(p.getClass()== Guerisseur.class)
                System.out.print(p.getNom()+";");
        }
        System.out.println();
        System.out.println("Choisir le nom du guérisseur");
        String nomGuerisseur = scanner.nextLine();
        for(Personnage p : personnages){
            if(p.getPointsDeVie()< p.getPointsDeVieMax())
                System.out.print(p.getNom()+";");
        }
        System.out.println();
        System.out.println("Choisir le nom du personnage à soigner");
        String nomGuerit = scanner.nextLine();
        Guerisseur guerisseur = (Guerisseur) trouverPersonnageParNom(nomGuerisseur);
        Personnage guerit = trouverPersonnageParNom(nomGuerit);
        if(guerisseur!=null && guerit!=null){
            guerisseur.soinPersonnage(guerit);
            System.out.println("PV du personnage après le soin : "+guerit.getPointsDeVie());
        }
    }
    public void sort(){
        for(Personnage p : personnages){
            if(p.getClass()== Sorcier.class)
                System.out.print(p.getNom()+";");
        }
        System.out.println();
        System.out.println("Choisir le nom du sorcier");
        String nomSorcier = scanner.nextLine();
        for(Personnage p : personnages){
            System.out.print(p.getNom()+";");
        }
        System.out.println();
        System.out.println("Utiliser un sort sur qui ?");
        String nomMalediction = scanner.nextLine();
        Sorcier sorcier = (Sorcier) trouverPersonnageParNom(nomSorcier);
        Personnage maudit = trouverPersonnageParNom(nomMalediction);
        if(sorcier!=null && maudit!=null){
            sorcier.sort(maudit);
            System.out.println("Etat de "+maudit.getNom() + " : "+maudit.getEtat());
        }
    }


}
