package interp;

import java.util.Optional;

public class NonEmptyEnv extends Env {
    private final Binding last;
    private final Env previous;

    public NonEmptyEnv(Binding last, Env previous) {
        this.last = last;
        this.previous = previous;
    }


    @Override
    Binding last() {
        return this.last;
    }

    @Override
    Env previous() {
        return this.previous;
    }

    @Override
    public Env add(String id, Value value) {
        Binding nouveau = new Binding(id, value);
        return new NonEmptyEnv(nouveau, this);
    }

    @Override
    public Optional<Value> lookup(String id) {
        if (this.last.name.equals(id)){
            return Optional.ofNullable(this.last.value);
        }else {
            return previous.lookup(id);
        }
    }
}
