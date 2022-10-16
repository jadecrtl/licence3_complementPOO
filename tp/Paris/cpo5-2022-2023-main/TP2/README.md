# TP2

Voir [TP2](https://moodle.u-paris.fr/pluginfile.php/1558909/mod_resource/content/1/tdtp2.pdf)

## Exercice 1
Cette question se concentre sur les champs privés.  
Oui, cela compile. On peut modifier le champ privé avec la méthode statique sans problème.
Ligne 43: (3, 5)
Ligne 46: (22, 11)
Ligne 50: (6, 17)
Ligne 52: (28, 28)

Le champ privé concerne les classes extérieures. 
```java
// Point.java
class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static void modifPoint(Point target, Point
    source) {
        target.x = source.y;
        target.y = source.x;
    }

    //peut-on accéder aux attributs privés d'un autrepoint ?
    public void addThis( Point other ){ 
        this.x += other.x ;
        this.y += other.y ;
    }

    public void addOther(Point other) {
        other.x += this.x;
        other.y += this.y;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }
// Other File Main.java
public class Main {
    public static void main(String[] args) {
        Point a = new Point(3, 5);
        Point b = new Point(11, 22);
        System.out.printf( "a=%s\n",a );
        //modifier a par une méthode static ?
        Point.modifPoint(a, b);
        System.out.printf("a=%s\n", a );
        Point o = new Point( -5, -5);
        //modifier o par b ?
        b.addOther(o);
        System.out.printf("o=%s\n",o);
        b.addThis(a);
        System.out.printf("b=%s\n", b);
    }
}
```
## Exercice 2
```java
    Cours couture = new Cours("Couture", copains);
    Cours karate = new Cours("Karate", copains);
    //Coralie est exclue du cours de Couture
    couture.exclut(p3);
    //Désiré s'inscrit à celui de Karaté
    karate.inscrit(p4);
```
On exclut p3 -> ensuite inscription p4 -> change nom p1.
Affichage:
```bash
Adeline
Brian
Désiré
```

On travaille sur le même hashset (object), donc il modifie et cela propage partout. La solution c'est a l'instant qu'on construit l'objet Cours, on fasse une copie.

```java
public Cours(String nom, HashSet<Personne> inscrits) {
    this.nom = nom; // Ici ça va, car String est imutable. + objet primitive.
    (this.inscrits = newHashSet<>()).addAll(inscrits);
}
```

## Exercice 3



```java
public final class CurriculumVitae { // final dans une classe? voir détails.
    private Bac bac;
    private Licence licence;
    private DiplomeInge diplome_eng;
    private Master master;
    private Doctorat doctorat;

    // getters
    public Bac getBac() {
        return this.bac;
    }
    public Licence getLicence() {}
    public DiplomeInge getDiplomeInge() {}
    // ... et pareil pour les autres diplomes.

    public CurriculumVitae(Bac bac, Licence licence, DiplomeInge diplomeIng, Master master, Doctorat doc) {
        // conditions d'initialisation
        if(bac == null && licence != null) ||
        (bac == null && diplomeIng != null) || . . . // autres verifications
            throw new IllegalArgumentExceptions("Conditions not validated");
        else {
            this.bac = bac // ...
        }
    }

    public CurriculumVitae(Bac bac, Licence lic, Master master) {
        this(bac, . . . );
    }
}

public abstract class Diplome {
    public final String intitule;
    public final Mention mention;
    public final int annee;

 public Diplome(String intitule, Mention mention, int annee) {
    this.intitule = intitule;
    this.mention = mention;
    this.annee = annee;
    }
 }

 public final class Bac extends Diplome {
    public Bac(String intitule, Mention mention, int annee) {
        super(intitule, mention, annee);
    }
 }

 // et pareil pour DAEU, Licence, DiplomeInge, Master, Doctorat...

 // le type Mention est défini comme suit :
 public enum Mention { PASSABLE, ASSEZ_BIEN, BIEN, TRES_BIEN, FELICITATIONS; }
```

## Exercice 4 - 5

```java
public void setBac(Bac bac) {
    this.bac = bac;
}
// etc . . . 
// bac est private mais pas final.
// il faut ajouter dans la bonne ordre 
// pas remettre à nulle - il faut autoriser.

public boolean setMaster(Master master) {
    if(master == null) return false;
    if(this.licence == null && this.dIng == null) return false
    if(this.master != null) return false // on change pas le diplome 
    this.master = master;
    return true;
}
```


## Exercice 6
```java
public final class CurriculumVitae { // final dans une classe? voir détails.
    private Bac bac;
    private Licence licence;
    private DiplomeInge diplome_eng;
    private Master master;
    private Doctorat doctorat;
    
    public CurriculumVitae(CVBuilder builder) {
        // verify conditions before construction
        // actually no - use the TP1 as reference for builder construction. Check TP1 Exercice 5 for Builder design pattern.)
    }
// sous classe de Curriculum Vitae
    class CVBuilder{
        Bac bac;
        Licence lic;
        DiplEng dpleng;
        Master master;
        Doctorat doc;
    }
```