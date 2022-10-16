package TP1;

public class Employe {
  private final String nom;
  private final String prenom;
  private final SimpleDate dateEmbauche;
  private static final Employe chef = new Employe("César", "Jules", new SimpleDate(14, 02, 400));

  /**
   * @param nom
   * @param prenom
   * @param dateEmbauche
   */
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

  public static Employe getChef() {
    return Employe.chef;
  }
  // public SimpleDate getDateEmbauche() {
  //   return dateEmbauche; // Even with final, we can use setters to modify the object SimpleDate, the final won't work.
  // }

  public SimpleDate getDateEmbauche() {
    return new SimpleDate(dateEmbauche.getJour(), dateEmbauche.getMois(), dateEmbauche.getAnnee());
  }

  public String toString() {
    return String.format("Name: %s %s", this.getNom(), this.getPrenom());
  }

}
