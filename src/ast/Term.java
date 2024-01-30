package ast;
import interp.Env;
import interp.Value;
import typer.Type;

public abstract class Term extends AST {
    abstract public Value interp(Env e);
    public abstract Type typer(Env e);
}
