package TP2;

public class Personne {
  private String nom;
  private final int numSecu;

  public Personne(String nom, int numSecu) {
    this.nom = nom;
    this.numSecu = numSecu;
  }

  public void changeNom(String nom) {
    this.nom = nom;
  }

  @Override
  public String toString() {
    return String.format("%s %d", nom, numSecu);
  }
}
