package TP2;

import java.util.HashSet;

public class Cours {
  private String nom;
  private HashSet<Personne> inscrits;

  public Cours(String nom, HashSet<Personne> inscrits) {
    this.nom = nom;
    // this.inscrits = inscrits;
    (this.inscrits = new HashSet<>()).addAll(inscrits);
  }

  public boolean exclut(Personne p) {
    return inscrits.remove(p);
  }

  public boolean inscrit(Personne p) {
    return inscrits.add(p);
  }

  public HashSet<Personne> getInscrits() {
    return inscrits;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder().append(nom);
    for (Personne personne : inscrits) {
      builder.append("\n").append(personne);
    }
    return builder.toString();
  }
}
