package ast;
import interp.Env;
import interp.Value;

public abstract class Term extends AST {
    abstract public Value interp(Env e);
}
