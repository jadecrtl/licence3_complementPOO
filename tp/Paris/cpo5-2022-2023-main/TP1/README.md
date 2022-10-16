# TP1 
- Voir [TP1](https://moodle.u-paris.fr/pluginfile.php/1539397/mod_resource/content/2/TP1.pdf)
## Exercice 1
1. Oui, see [Java Byte Code](https://stackoverflow.com/questions/18385673/how-does-java-bytecode-deal-with-multiple-platforms)
>The bytecode for a 100% pure Java program is indeed platform-independent. The underlying Java platform classes that such programs invoke are, of course, not.


2. No, see [JVM](https://www.infoworld.com/article/3272244/what-is-the-jvm-introducing-the-java-virtual-machine.html)
Java Virtual Machine, or JVM, loads, verifies and executes Java bytecode. It is known as the interpreter or the core of Java programming language because it executes Java programming.

3. Oui. The this keyword refers to the current object in a method or constructor. The most common use of the this keyword is to eliminate the confusion between class attributes and parameters with the same name (because a class attribute is shadowed by a method or constructor parameter).
4. What is the default constructor? Java doesn't require a constructor when we create a class. However, it's important to know what happens under the hood when no constructors are explicitly defined. The compiler automatically provides a public no-argument constructor for any class without constructors.
5. public is a Java keyword which declares a member's access as public. Public members are visible to all other classes. This means that any other class can access a public field or method. Further, other classes can modify public fields unless the field is declared as final .
6. No, [Java garbage collector](https://www.dynatrace.com/resources/ebooks/javabook/how-garbage-collection-works/)
7. No. The static keyword in Java is mainly used for memory management. The static keyword in Java is used to share the same variable or method of a given class. The users can apply static keywords with variables, methods, blocks, and nested classes. The static keyword belongs to the class than an instance of the class.

## Exercice 2
```java
class Truc {
    2 static int v1 = 0;
    3 int v2 = 0;
    4 public int getV1() { return v1; }
    5 public int getV2() { return v2; }
    6 public Truc() {
    7 v1++; v2++;
    8 }
9 }
```
1. At right, he checks the value and then increments. At left, the other way around. **(referring to the + signe)**
>Line 13: 1     
>Line 14: 1     
>Line 15: 3 (v1 is a static variable) 

## Exercice 3

```java
public class EvenNumbersGenerator { 
    static int MAX = 42; 
    public int previous = 0; 
    public int next() { 
        previous += 2; previous %= MAX; 
        return previous; 
    } 
} 
```

- On peut modifier previous. Donc la méthode ne vas pas retourner une valeur paire. Même chose pour le `MAX`   

```java
EvenNumbersGenerator example = new EvenNumbersGenerator();
example.previous = 1;
System.out.println(example.next()); // 3

// Solution ->
private int previous = 0;
private final static MAX = 42;
```
Partie 2 de la question.
```java
public class VectAdditioner { 
    private Point sum = new Point(); 
    public void add(Point p) { 
        sum.x += p.x; sum.y += p.y; 
    } 
    public Point getSum() { 
        return sum; 
    } 
} 
```

> Problèmes. Objet est privé mais on a accès à la réference.
```java
VectAdditioner v = new VectAdditioner();
Point p = v.getSum()
p.x = -10;

// Solution - comme ça personne peux modifier la somme.
public Point getsum() {
    return new Point(sum.x, sum.y)
}
```
## Exercice 4

```java
@Override 
public String toString() {
    return String.format("%d/%d/%d", jour, mois, annee)
}

// Author: @Léo
public boolean isValid(int jour, int mois, int annee) {
    boolean bissextile = (annee % 4 == 0 && annee % 100 != 0) || annee % 400 == 0;

    if(jour <= 0 || mois <= 0 || mois > 12)
        return false;

    if(mois == 2) {
        System.out.println("Anniversaire Paris Mollo Christondis");
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
            return false:
    }

```

```java
public SimpleDate(int jour, int mois, int annee ) throws IllegalArgumentException{
    if(!isValid(jour, mois, annee)) {
        throw new IllegalArgumentException("Date not valid");
    }
    this.jour = jour;
    this.mois = mois;
    this.annee = annee;
}
```


```java
public class Employe {
    private String nom;
    private String prenom;
    private SimpleDate dateEmbauche;

    public Employe(String nom, String prenom, SimpleDate dateEmbauche) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateEmbauche = dateEmbauche;
}

// Solution
Employe e = new Employe("Nom", "Prenom", new SimpleDate(e.getDateEmbauche().setAnnee(2020)));
e.getNom();
. . .
public SimpleDate getDateEmbauche() { // Important!! On envoie une copie et cela on peut modifer mais pas la vrai valeur.
    return new SimpleDate(dateEmbauche.jour, dateEmbauche.mois, dateEmbauche.annee);
}
. . .
public class Employe {
    private static final chef = new Employe(. . . )
    . . . 
    public static Employe getChef() {
        return Employe.chef
    }
    . . .
}

```

## Exercice 5
```java
public class PreciousStone {
    private String species; /* beryl */
    private String variety; /* emerald aquamarine heliodor morganite etc */
    private BigDecimal refractiveIndex;
    private BigDecimal weight;
    private int hardness; /* entre 1 et 10 */
    private String cleavage; /* basal, pinacoidal, cubic planar, octahedral, dodecahedral etc */
    private boolean inclusions;
    private int water; /* 1, 2, 3 */
}

```
- [x] variety et species fournies à la creation de l'instance.
- [x] Les autres champs, appelons les « facultatifs » : refractiveIndex, weight, hardness, cleavage,
inclusions, water possèdent les valeurs par défaut que l’instance prendra si d’autres valeurs
ne sont pas spécifiées à la création de l’objet *(respectivement les valeurs par défaut : 1.77, 0.3, 8,
"octahedral", false, 1)*
- [x] À la création d’instance de PreciousStone l’utilisateur peut choisir
un sous-ensemble quelconque de champs facultatifs à initialiser explicitement et pour d’autres
champs facultatifs laisser les valeurs par défaut (cela donne 2
6 possibilités de choix d’ensemble
de champs à initialiser).

### Réponses
Pour résoudre cette question on a besoin d'utiliser le design pattern "Builder". - Voir 
[Code example](https://drive.google.com/file/d/1QlskcgwAliGsgDN27-OC5NP12DO4_3Od/view?usp=sharing)

https://www.geeksforgeeks.org/static-class-in-java/ ->
why Builder is nested and not inner class.

```java
public class PreciousStone {

    //Required arguments
    private String species; /* beryl */
    private String variety; /* emerald aquamarine heliodor morganite etc */

    //Optional arguments - initialized with default values
    private BigDecimal refractiveIndex = 1.77;
    private BigDecimal weight = 0.3;
    private int hardness = 8; /* entre 1 et 10 */
    private String cleavage = "octahedral"; /* basal, pinacoidal, cubic planar, octahedral, dodecahedral etc */
    private boolean inclusions = false;
    private int water = 1; /* 1, 2, 3 */

    // Question: Check how method in inner class access parent attributes. Why Builder is static. -> it has to be static because otherwise it would require a instace of the parent class.

    public static class Builder {
        private String species; /* beryl */
        private String variety; /* emerald aquamarine heliodor morganite etc */

        private BigDecimal refractiveIndex = 1.77;
        private BigDecimal weight = 0.3;
        private int hardness = 8; /* entre 1 et 10 */
        private String cleavage = "octahedral"; /* basal, pinacoidal, cubic planar, octahedral, dodecahedral etc */
        private boolean inclusions = false;
        private int water = 1; /* 1, 2, 3 */

        public Builder(String species, String variety) {
            this.species = species;
            this.variety = varity;
    }

        public Builder refractiveIndex(BigDecimal val) {
            refractiveIndex = val;
            return this;
        }

        public Builder weight(BigDecimal val) {
            weight = val;
            return this;
        }

        public Builder hardness(int val) {
            hardness = val;
            return this;
        }

        public Builder cleavage(String val) {
            cleavage = val;
            return this;
        }

        public Builder inclusions(boolean val) {
            inclusions = val;
            return this;
        }

        public Builder water(int val) {
            water = val;
            return this
        }

        public PreciousStone build() {
            // on peut ajouter ce genre de tests de cohérence
            if(checkSpecies() == false || checkVariety() == false || checkHardness() == false || checkcLeavage() == false || checkWater() == false) {
                throw new IllegalArgumentException();
            } 
            return new PreciousStone(this);
        }
    }

    private NutritionFactsB(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
	}
}

```
>How to use it? Similiar to the example from the CM1 - [Coca.java](https://drive.google.com/file/d/1r90pTQpld7vqggTEPN69qxF9052JnLIu/view?usp=sharing)

```java
NutritionFactsB pepsiCola = new NutritionFactsB.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();
```
## Exercice 6
à lire: [Java Constructeur Vs Fabrique Statique](https://fr.acervolima.com/difference-entre-le-constructeur-et-la-methode-d-usine-statique-en-java/)
```java
public class Complex {
    // a + b*i, where a is the real part and b is the imaginary part.
    private final double real_number;
    private final double imaginary_number;
    public static final int i_squared = -1;

    public Complex(double real, double imaginary) {
        this.real_number = real;
        this.imaginary_number = imaginary;
    }

    public Complex somme(Complex number_a, Complex number_b) {
        return new Complex(number_a.get_real_number()+number_b.get_real_number(), number_a.get_imaginary_number()+number_b.get_imaginary_number())
    }

    public Complex soustraction() {return new Complex(...);}//Pareil comme somme 
    public Complex division() {return new Complex(...);} // voir  http://villemin.gerard.free.fr/Wwwgvmm/Type/aaaCompl/Division.htm
    public Complex multiplication() {return new Complex(...);} // voir http://villemin.gerard.free.fr/Wwwgvmm/Type/aaaCompl/Multipli.htm 

    public boolean equals(Complex number) {
        return (this.get_real_number() == number.get_real_number()) && (this.get_imaginary_number == number.get_imaginary_number)
    }
    public double get_real_number() {return this.real_number;}
    public double get_imaginary_number() {return this.imaginary_number;}
    public Complex get_conjug_number(){
        return new Complex(this.get_real_number, this.get_imaginary_number * -1);
    }
    public double get_mod() {...}
    public double get_arg() {...}

    public String toString() {
        return String.format("%f + %fi", this.real_number, this.imaginary_number)
    }

    . . . 
}
```
>Note: Pas fini. Voir [Encapsulation](https://www.geeksforgeeks.org/encapsulation-in-java/)