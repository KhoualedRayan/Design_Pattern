import arme.BaguetteMagique;
import arme.BatonDeSorcier;
import arme.Epee;
import equipe.Equipe;
import personnage.*;
import visiteur.DegatVisiteur;
import visiteur.NiveauVisiteur;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Jeu {
    public static void main(String[] args) {
        DegatVisiteur degatVisiteur = new DegatVisiteur();
        NiveauVisiteur niveauVisiteur = new NiveauVisiteur();

        BaguetteMagique baguetteMagique = new BaguetteMagique(3,"Baguette magique",2.0,5);
        BatonDeSorcier batonDeSorcier = new BatonDeSorcier(5,"Baton de sorcier",2.0,"Feu");
        Epee epeeDuRoi = new Epee(5,"Excalibur",3.0,4);
        Epee epeeDuGuerrier = new Epee(4,"Rapière",1.5,3);

        Sorcier sorcier = new Sorcier(4,1,"Harry Potter",batonDeSorcier,6);
        Roi roi = new Roi(6,1,"Arthur",epeeDuRoi,6,"Bretagne");
        Guerrier guerrier = new Guerrier(8,1,"Perceval",epeeDuGuerrier,3);
        Guerisseur guerisseur = new Guerisseur(3,1,"Merlin",baguetteMagique,7);

        System.out.println(sorcier.toString());
        System.out.println(guerisseur.toString());
        System.out.println(roi.toString());
        System.out.println(guerrier.toString());

        sorcier.accept(niveauVisiteur);
        roi.accept(degatVisiteur);

        System.out.println(roi.toString());
        System.out.println(sorcier.toString());

        Equipe equipe1 = new Equipe();
        equipe1.ajouterMembreEquipe(roi,guerisseur);
        System.out.println("Equipe en bas : ");
        System.out.println(equipe1.getGroupes().toString());
        equipe1.accept(niveauVisiteur);
        System.out.println(equipe1.getGroupes().toString());
        System.out.println(equipe1);

    }
}