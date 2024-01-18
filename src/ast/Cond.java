package ast;

import interp.Env;
import interp.IntVal;
import interp.Value;

public class Cond extends Term {
    public Term test;
    public Term branchTrue; // non zero
    public Term branchFalse;

    public Cond(Term test, Term branchTrue, Term branchFalse) {
        this.test = test;
        this.branchTrue = branchTrue;
        this.branchFalse = branchFalse;
    }
    /*
    @Override
    public Value interp(Env e) {
        int BooleanValue = ((IntVal) test.interp(e)).value;
        if (BooleanValue == 0){
            return new IntVal(((IntVal) branchTrue.interp(e)).value);
        }else {
            return new IntVal(((IntVal) branchFalse.interp(e)).value);
        }
    };*/

    @Override
    public Value interp(Env e) {
        return switch (test.interp(e)) { // evaluate test
            case IntVal v -> {
                if (v.value == 0) {
                    yield branchTrue.interp(e);
                } // non zero
                else{
                    yield branchFalse.interp(e);
                }
            } // check it is an integer and unbox
            default -> throw new ArithmeticException("Not a number"); // raise en error
        };
    };
}
