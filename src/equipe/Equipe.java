package equipe;

import visiteur.VisiteurPers;

import java.util.ArrayList;
import java.util.Arrays;

public class Equipe implements Groupe{
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

    public ArrayList<Groupe> getGroupes() {
        return groupes;
    }

    public void ajouterMembreEquipe(Groupe... groupe){
        this.groupes.addAll(Arrays.asList(groupe));
    }
    public void supprimerMembreEquipe(Groupe... groupe){
        this.groupes.removeAll(Arrays.asList(groupe));
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "groupes=" + groupes +
                '}';
    }
}
