package ast;

import interp.Closure;
import interp.Env;
import interp.Value;

public class App extends Term{
    public Term term1;
    public Term term2;

    public App(Term term1, Term term2) {
        this.term1 = term1;
        this.term2 = term2;
    }

    @Override
    public Value interp(Env e) {
        Closure closure = (Closure) term1.interp(e);
        closure.env = closure.env.add(closure.x.name, term2.interp(e));
        if (closure.term instanceof Fun fun) {
            return new Closure(fun.var, fun.term, closure.env);
        } else {
            return closure.term.interp(closure.env);
        }
    }
}
