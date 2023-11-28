package outils;

public class Configuration {
    private int tailleMaxEquipe;
    private int Difficulte;
    private static final Configuration instance = new Configuration();
    private Configuration() {
    }

    public static Configuration getInstance() {
        return instance;
    }

    public int getTailleMaxEquipe() {
        return tailleMaxEquipe;
    }

    public void setTailleMaxEquipe(int tailleMaxEquipe) {
        this.tailleMaxEquipe = tailleMaxEquipe;
    }

    public int getDifficulte() {
        return Difficulte;
    }

    public void setDifficulte(int difficulte) {
        Difficulte = difficulte;
    }

}
