import facade.JeuFacade;

import java.util.Scanner;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Jeu {
    public static void main(String[] args) {
        boolean jeuEnCours =true;
        String action = null;
        Scanner scanner = new Scanner(System.in);
        JeuFacade jeuFacade = new JeuFacade();

        while (jeuEnCours){
            System.out.println("\nVeuillez saisir votre prochaine action.");
            System.out.println("0-Quitter 1-Créer un personnage 2-Supprimer un personnage 3-Créer une équipe 4-Supprimer une équipe");
            System.out.println("5-Ajouter un membre dans une équipe 6-Supprimer un membre d'une équipe 7-Améliorer une équipe 8-Attaquer un personnage");
            System.out.println("9-Soigner un personnage 10-Lancer un sort 11-Défaire la dernière action 12-Refaire la dernière action\n");
            action = scanner.nextLine();
            switch (action){
                case "0":
                    jeuEnCours = false;
                    break;
                case "1":
                    jeuFacade.creerPersonnage();
                    break;
                case "2":
                    jeuFacade.supprimerPersonnage();
                    break;
                case "3":
                    jeuFacade.creerEquipe();
                    break;
                case "4":
                    jeuFacade.supprimerEquipe();
                    break;
                case "5":
                    jeuFacade.ajouterMembreEquipe();
                    break;
                case "6":
                    jeuFacade.supprimerMembreEquipe();
                    break;
                case "7":
                    jeuFacade.ameliorerEquipe();
                    break;
                case "8":
                    jeuFacade.attaquer();
                    break;
                case "9":
                    jeuFacade.soin();
                    break;
                case "10":
                    jeuFacade.sort();
                    break;
                case "11":
                    jeuFacade.undo();
                    break;
                case "12":
                    jeuFacade.redo();
                    break;
            }
        }
        System.out.println("Jeu fini :D !");

    }
}