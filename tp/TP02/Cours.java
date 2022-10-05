import java.util.HashSet;

class Cours {
    private String nom;
    private HashSet<Personne> inscrits;

    public Cours(String nom, HashSet<Personne> inscrits) {
        this.nom = nom;
        this.inscrits = inscrits;
    }    

    //return false si pas dans la liste des isncrits au depart
    public boolean exclut(Personne p) {
        return inscrits.remove(p);
    }

    //return false si deja dans liste des inscrits au depart

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
