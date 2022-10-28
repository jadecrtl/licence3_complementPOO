import java.util.List;
import java.util.Map;

public class Context {
    public abstract static class Formule extends Context {

        public static final class Variable extends Formule {
            private String name;
            public Variable(String name) { 
                this.name = name;
            }
            public String toString() {
                return name;
            }
        }
        
        public static final class Value extends Formule {
            private boolean value;
            public Value(boolean value) { 
                this.value = value;
            }
            public String toString() {
                if (value == true)
                    return ("true");
                return ("false");
            }
        }

        public static final class And extends Formule {
            private List<Formule> arguments;
            public And(List<Formule> arguments) {
                this.arguments = arguments;
            }
            public String toString() {
                String res = "(and";
                for (Formule formule : arguments) {
                    res += " " + formule.toString();
                }
                res += ")";
                return res;
            }
        }

        public static final class Or extends Formule {
            private List<Formule> arguments;
            public Or(List<Formule> arguments) {
                this.arguments = arguments;
            }
            public String toString() {
                String res = "(or";
                for (Formule formule : arguments) {
                    res += " " + formule.toString();
                }
                res += ")";
                return res;
            }
        }
        
        public static final class Neg extends Formule {
            private final Formule f;

            public Neg(Formule f) {
                this.f = f;
            }

            public String toString() {
                String res = "(not";
                res += " " + f.toString();
                res += ")";
                return res;
            }
        }
        
        public Formule substitute(Map<String, Formule> substitution) {
            if (this instanceof Variable) {
                Variable v = (Variable) this;
                if (substitution.containsKey(v.name)) {
                    return substitution.get(v.name);
                }
                return v;
            }
            if (this instanceof Value) {
                Value v = (Value) this;
                return v;
            }
            if (this instanceof And) {
                And a = (And) this;
                List<Formule> newArgs = List.of();
                for (Formule f : a.arguments) {
                    newArgs.add(f.substitute(substitution));
                }
                return new And(newArgs);
            }
            if (this instanceof Or) {
                Or o = (Or) this;
                List<Formule> newArgs = List.of();
                for (Formule f : o.arguments) {
                    newArgs.add(f.substitute(substitution));
                }
                return new Or(newArgs);
            }
            if (this instanceof Neg) {
                Neg n = (Neg) this;
                return new Neg(n.f.substitute(substitution));
            }
            return null;
        }
    }

    public static Formule Variable(String name) {
        return new Formule.Variable(name);
    }


    public static Formule Value(boolean value) {
        return new Formule.Value(value);
    }

    public static Formule And(List<Formule> arguments) {
        return new Formule.And(arguments);
    }

    public static Formule Or(List<Formule> arguments) {
        return new Formule.Or(arguments);
    }

    public static Formule Neg(Formule argument) {
        return new Formule.Neg(argument);
    }
}

