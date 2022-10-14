public abstract class Diplome {
    public final String intitule;
    public final Mention mention;
    public final int annee;

    public Diplome(String intitule, Mention mention, int annee) {
        this.intitule = intitule;
        this.mention = mention;
        this.annee = annee;
    }

    public final class Bac extends Diplome {
        public Bac(String intitule, Mention mention, int annee) {
            super(intitule, mention, annee);
        }
    }

    public final class DAEU extends Diplome {
        public DAEU(String intitule, Mention mention, int annee) {
            super(intitule, mention, annee);
        }
    }

    public final class Licence extends Diplome {
        public Licence(String intitule, Mention mention, int annee) {
            super(intitule, mention, annee);
        }
    }

    public final class DiplomeInge extends Diplome {
        public DiplomeInge(String intitule, Mention mention, int annee) {
            super(intitule, mention, annee);
        }
    }
    
    public final class Master extends Diplome {
        public Master(String intitule, Mention mention, int annee) {
            super(intitule, mention, annee);
        }
    }


    public final class Doctorat extends Diplome {
        public Doctorat(String intitule, Mention mention, int annee) {
            super(intitule, mention, annee);
        }
    }


    public enum Mention { PASSABLE, ASSEZ_BIEN, BIEN, TRES_BIEN, FELICITATIONS; }
    
}
