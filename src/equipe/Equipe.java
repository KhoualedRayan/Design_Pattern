package equipe;

import outils.Configuration;
import visiteur.VisiteurPers;

import java.util.ArrayList;
import java.util.Arrays;

public class Equipe implements Groupe{
    private String nomEquipe;
    private ArrayList<Groupe> groupes;

    public Equipe() {
        this.groupes = new ArrayList<>();
    }

    @Override
    public void accept(VisiteurPers vp) {
        for(Groupe g : groupes){
            g.accept(vp);
        }
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public ArrayList<Groupe> getGroupes() {
        return groupes;
    }

    public void ajouterMembreEquipe(Groupe... groupe){
        for (Groupe g : groupe){
            if(this.groupes.size()< Configuration.getInstance().getTailleMaxEquipe())
                this.groupes.add(g);
            else
                System.out.println("Taille max de l'equipe atteinte");
        }
    }
    public void supprimerMembreEquipe(Groupe... groupe){
        this.groupes.removeAll(Arrays.asList(groupe));
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "nomEquipe='" + nomEquipe + '\'' +
                ", groupes=" + groupes +
                '}';
    }
}
