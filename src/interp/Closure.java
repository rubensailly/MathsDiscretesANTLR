package interp;

import ast.Term;
import ast.Var;

public class Closure extends Value{

    public Var x;
    public Term term;
    public Env env;

    public Closure(Var x, Term t, Env e) {
        this.x = x;
        this.term = t;
        this.env = e;
    }
    @Override
    public String toString() {
        return "Closure{" +
                "x=" + x +
                ", term=" + term +
                ", env =" + env +
                '}';
    }

}
