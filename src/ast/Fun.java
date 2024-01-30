package ast;

import interp.Closure;
import interp.Env;
import interp.Value;

public class Fun extends Term{
    public Var var;
    public Term term;

    public Fun(Var var, Term term) {
        this.var = var;
        this.term = term;
    }


    @Override
    public Value interp(Env e) {
        return new Closure(var, term, e);
    }
}
