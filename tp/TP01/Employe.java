public class Employe {
    private String nom;
    private String prenom;    
    private SimpleDate dateEmbauche;
    
    public Employe(String nom, String prenom, SimpleDate dateEmbauche) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateEmbauche = dateEmbauche;
    }
    
    public String getNom() {
        return nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public SimpleDate getDateEmbauche() {
        return dateEmbauche;
    }

    
}