package ast;

import interp.Env;
import interp.IntVal;
import interp.Value;
import typer.Type;
import typer.TypeError;

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
        Value t1 = term1.interp(e);
        Value t2 = term2.interp(e);

        if (t1 instanceof IntVal intVal1) {
            if (t2 instanceof IntVal intVal2) {
                return switch(op){
                    case PLUS -> new IntVal(intVal1.value + intVal2.value);
                    case MINUS -> new IntVal(intVal1.value - intVal2.value);
                    case DIVIDE -> new IntVal(intVal1.value / intVal2.value);
                    case TIMES -> new IntVal(intVal1.value * intVal2.value);
                };
            }else{
                throw new IllegalArgumentException("Unexpected operand: " + t2);
            }
        }else{
            throw new IllegalArgumentException("Unexpected operand: " + t1);
        }
    }

    @Override
    public Type typer(Env e) {
        Type a = term1.typer(e); // le type A de t
        Type b = term2.typer(e); // le type B de u
        if (a.unify(b)) { // unification A = B
            return a;
        } else {
            throw new TypeError("Couldn't unify " + term1.toString() + " and " + term2.toString());
        }
    }
}
