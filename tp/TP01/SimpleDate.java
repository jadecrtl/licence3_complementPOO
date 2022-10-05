public class SimpleDate {
    private int jour;
    private int mois;
    private int annee;

    public int getAnnee() {
        return annee;
    }

    public int getJour() {
        return jour;
    }

    public int getMois() {
        return mois;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public SimpleDate(int jour, int mois, int annee) throws IllegalArgumentException{
        if (isValid(jour, mois, annee) == false) {
            throw new IllegalArgumentException();
        }
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    public String toString() {
        return this.jour + "/" + this.mois + "/" + this.annee;
    }

    public static boolean isValid(int jour, int mois, int annee) {
        if (jour != 0 || mois != 0) {
            if (mois == 2) {
                if ((annee / 4 == 0 && annee / 100 != 0) || annee / 400 == 0) {
                    if (jour > 0 && jour < 30) {
                        return true;
                    }
                }
                else {
                    if (jour > 0 && jour < 31) {
                        return true;
                    }
                }
            }
            if (mois == 1 || mois == 3 || mois == 5 || mois == 7 || mois == 8 || mois == 10 || mois == 12) {
                if (jour > 0 && jour < 32) {
                    return true;
                }
            }
            if (mois == 2 || mois == 4 || mois == 6 || mois == 9 || mois == 11) {
                if (jour > 0 && jour < 31) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SimpleDate date1 = new SimpleDate(10, 3, 2022);
        System.out.println(date1.toString());
        SimpleDate date2 = new SimpleDate(00010, 0003, 002022);
        System.out.println(date2.toString());
        System.out.println(00010 + " ");

        //Test pour vérifier la méthode isValide() avec erreur
        System.out.println(isValid(-1, 12, 0)); //false
        System.out.println(isValid(32, 12, 0)); //false
        System.out.println(isValid(31, 2, 1)); //false
        System.out.println(isValid(32, 3, 0)); //false
        System.out.println(isValid(31, 4, 0)); //false
        System.out.println(isValid(12, 13, 0)); //false
        System.out.println(isValid(12, -1, 0)); //false
        System.out.println(isValid(12, 40, 0)); //false
        System.out.println(isValid(12, 0, 0)); //false

        //Test pour vérifier la méthode isValide()
        System.out.println(isValid(00012, 00003, 00000)); //true
    }
}
