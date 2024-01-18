package ast;

import interp.Env;
import interp.IntVal;
import interp.Value;

public class BinOp extends Term {
    public OP op;
    public Term term1;
    public Term term2;
    public BinOp(OP op, Term term1, Term term2) {
        this.op = op;
        this.term1 = term1;
        this.term2 = term2;
    }

    @Override
    public Value interp(Env e) {
        int t1 = ((IntVal) term1.interp(e)).value;
        int t2 = ((IntVal) term2.interp(e)).value;

        return switch(op){
            case PLUS -> new IntVal(t1 + t2);
            case MINUS -> new IntVal(t1 - t2);
            case DIVIDE -> new IntVal(t1 / t2);
            case TIMES -> new IntVal(t1 * t2);
        };
    }
}
