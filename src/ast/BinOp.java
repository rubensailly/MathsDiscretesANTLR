package ast;

import interp.Env;
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

        return switch(op){
            case PLUS -> term1 + term2;
            case MINUS -> term1 - term2;
            case DIVIDE -> term1 / term2;
            case TIMES -> term1 * term2;
        }
    }
}
