import java.util.HashSet;

public class Cours {
    private String nom;
    private HashSet<Personne> inscrits;

    public Cours(String nom, HashSet<Personne> inscrits) {
        this.nom = nom;
        this.inscrits = (HashSet<Personne>)inscrits.clone();
    }

    //return false si pas dans la liste
    // des inscrits au départ
    public boolean exclut(Personne p) {
        return inscrits.remove(p);
    }

    public boolean inscrit(Personne p) {
        return inscrits.add(p);
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder().append(nom);
        for (Personne p : inscrits) {
            builder.append("\n").append(p);
        }
        return builder.toString();
    }
}
