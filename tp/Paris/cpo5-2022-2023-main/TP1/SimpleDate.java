package TP1;

public class SimpleDate {
  private int jour;
  private int mois;
  private int annee;

  public SimpleDate(int jour, int mois, int annee) {
    if(!isValid(jour, mois, annee)) throw new IllegalArgumentException("Date is not valid");
    this.jour = jour;
    this.mois = mois;
    this.annee = annee;
  }

  public int getJour() {
    return jour;
  }
  public void setJour(int jour) {
    this.jour = jour;
  }
  public int getMois() {
    return mois;
  }
  public void setMois(int mois) {
    this.mois = mois;
  }
  public int getAnnee() {
    return annee;
  }
  public void setAnnee(int annee) {
    this.annee = annee;
  }
  @Override
  public String toString() {
    return String.format("%d/%d/%d", this.getJour(), this.getMois(), this.getAnnee());
  }

  public static boolean isValid(int jour, int mois, int annee) { // We do static because otherwise why get params instead of using this.
    boolean bissextile = (annee % 4 == 0 && annee % 100 != 0) || annee % 400 == 0;

    if(jour <= 0 || mois <= 0 || mois > 12)
        return false;

    if(mois == 2) {
        //System.out.println("Anniversaire Paris Mollo Christondis");
        int max = bissextile ? 29 : 28;
        if(jour > max)
            return false;
    }
    else {
        boolean pair = mois % 2 == 0;
        int maxJour = 0;
        if(mois <= 7)
            maxJour = pair ? 30 : 31;
        else if(mois <= 12)
            maxJour = pair ? 31 : 30;
        if(jour > maxJour)
            return false;
    }
    return true;
  }
}
