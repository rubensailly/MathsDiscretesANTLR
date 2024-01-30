package ast;

import interp.Env;
import interp.Value;

public class Var extends Term{
    public final String name;

    public Var(String name) {
        this.name = name;
    }

    @Override
    public Value interp(Env e) {
        Value value = e.lookup(name).orElseThrow(() -> new RuntimeException("Variable non définie"));
        if (e.lookup(name).isPresent()){
            return e.lookup(name).get();
        }
        throw new RuntimeException("Variable non définie");
        /*else{
            return e.lookup(name).orElseThrow(RuntimeException::new);
        }*/
    }
}
