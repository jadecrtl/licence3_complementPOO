# TP3

## Ex1
1.  Non -> implements.
2.  Non
3.  Ok
4.  Non
5.  Ok 
6.  interface k extends I, J - Ok
7.  Non
8.  Oui
   
## Ex2

B -> A <- C

a) ligne 10, ligne 18, 20
b) éxecution - 19. Exception class exception
```java
A a = null;
B b = (B) a;
```
c)      
11 -> code ascii de 'a'  
13 -> 1 
14 -> 'b'   
15 -> 98.0  
16-> 'b'    

We can do smaller to larger without explict casting. (store in larger the smaller class)
But from a larger to smaller has to be explicit. 
## Ex3

### 1.
- class C extends B
- class D extends B
- class B extends 

15) Canditats 11, 7. - Son A A
16) pareil que lingne 15. -> Son A A
17) ligne 8 f. -> Dad A B
18) -> Dad A B

### 2.
Appel ambigu pour 
```java
f(new C(), new B())
f(new C(), new B())
```

On peut utiliser 
```java
Dad.f(. . .)
```

x de type A au n'importe quel type de descendant.
et y de type A.

## Ex4
### 1. 
```java
public interface Sequencable {
    ... 
    default public affiche() {
        for (int i=0; i<longeur(), i++) {
            System.out.println(get(i).value());
        }
    }

    default void triBulles() {
        boolean change = false;
        do {
            change = false;
            for (int i=0; i<longueur(); i++) {
                if (get(i).estPlusGrand(get(i+1))) {
                echange(i, i+1)
                change = true;
                }
            }
        } while (change)
    }
    // or static public triBulles(...) {...}
}

```

### 3
```java
public class MotComparable implements Comparable {
    private String mot;

    public MotComparable(String mot) {
        this.mot = mot;
    }

    @Override
    public Object value() {
        return this.mot;
    }

    @Override
    public boolean estPlusGrand(Comparable i) {
        if(!(i instanceof String)) {
            throw new IllegarArgumentException();
        }
        String m1 = (String) this.value();
        String m2 = (String) i.value();
        return m1.compareTo(m2) > 0;
    }
}
```
### 4
```java
public class SequenceMots implements Sequencable{
    private MotsComparable[] mots;
    public SequenceMots(String[] mots) {
        this.mots = new MotsComparables[mots != null ? mots.lenght : 0];
        for(int i=0; i<mots.lenght; i++) {
            this.mots[i] = new MotComparable[mots[i]];
        }
    }

    public int longueur() {
        return this.mots.lenght;
    }
    public Comparable get(int i) {
        if (i>=0) return this.mots[i];
    }
    public void echange(int i, int j) {
        MotComparable temp = get(i);
        this.mots[i] = get(j);
        this.mots[j] = temp;
    }
}
```

## Exercice 5
```java
Generateur fib = GenLib.nouveauGenerateurFibonacci();
for (int i = 0; i < 10; i++) 
    System.out.println(fib.suivant());

public class GenLib {
    interface Generateur{
        int suivant();
    }

    private GenLib() {} // non instanciable.

    public static Generateur nouveauAleatoire(int m) {
        return new Generateur() {
            @Override
            public int suivant(){
                return (int) (Math.random() * m);
            }
        }
    }

    public static nouveauAleatoire(int u) { // ici je n'ai pas compris, on est pas censé de renvoyer une objet generateur. voir https://www.javatpoint.com/java-lambda-expressions
        return () -> (int) Math.random() * m;
    }
    public static Generateur SA(int r) {
        return new Generateur() { // Anonym class
            int i = 0;
            public int suivant() {
                return i++ * r; // before ou after check which is which. Here I think he firsts evaluates i ** r then updates the value of i.
            }
        }
    }

    // Autre façon de le faire, je pourrai aussi mettre la def de GenerateurGeometrique hors le method SG en private et static et ensuite je fais return new generateur geometrique dans SG mais je dois passer en paramètre.
    public static Generateur SG(int r) {
        class GenerateurGeometrique implements Generateur {
            int prochain = 1;
            @Override
            public int suivant() {
                int courant = prochain;
                prochain *= r
                return courant;
            }
        }
        return new GenerateurGeometrique();
    }

    public static Generateur nouveauFibo() {
        return new Generateur() {
            int i = 1;
            int j = 0;
            public int suivant() {
                int k = i + j;
                i = j;
                j = k;
                return k;
            }
        }
    }

    public static int Somme(Generateur gen, int n) {
        int somme = 0;
        while(n>0) {
            somme += gen.suivant();
            n-=1;
        }
        return somme;
    }

    public static void main(String[] args) {
        System.out.println("Pick a gen: a) Random b) SA c)SG d) Fibo");
        Scanner myObj = new Scanner(System.in);
        String option = myObj.nextLine();
        . . . 
    }
}

```


Exercice 5.5

```java
//example d'usage
GenLib.Generateur g = new CollectionToGenerateur(List.of(5, 7, 10, 25));
g.suivant();
//fin example

public class CollectionToGenerateur implements GenLib.Generateur {
    //private Collection<Int> c; pas nécessaire
    private Iterator<Int> iterator;

    public CollectionToGenerateur(Collection<Int> c) {
        //this.c = c; pas necesaire
        this.iterator = c.iterator();
    }

    @Override
    public int suivant() {
        return this.iterator.next();
    }
}
```