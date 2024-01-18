package ast;

import interp.Env;
import interp.Value;

public class Let extends Term{
    public Term Variable;
    public Term t1; // non zero
    public Term t2;

    public Let(Term test, Term branchTrue, Term branchFalse) {
        this.Variable = test;
        this.t1 = branchTrue;
        this.t2 = branchFalse;
    }

    @Override
    public Value interp(Env e) {
        return null;
    }
}
