package ast;

import interp.Env;
import interp.Value;

public class Let extends Term{
    public String Variable;
    public Term t1; // non zero
    public Term t2;

    public Let(String test, Term branchTrue, Term branchFalse) {
        this.Variable = test;
        this.t1 = branchTrue;
        this.t2 = branchFalse;
    }

    @Override
    public Value interp(Env e) {
        //e = e.add(Variable, t1.interp(e));
        e.add(Variable, t1.interp(e));
        return t2.interp(e);
    }
}
