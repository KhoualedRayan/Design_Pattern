package visiteur;

import equipe.Equipe;
import equipe.Groupe;
import personnage.Sorcier;

public class CompteurSorcierVisiteur implements  VisiteurEquipe{
    @Override
    public int visitEquipe(Equipe e) {
        int compt = 0;
        for(int i=0;i<e.getGroupes().size();++i){
            if(e.getGroupes().get(i).getClass() == Sorcier.class){
                compt++;
            }
        }
        return compt;
    }
}
