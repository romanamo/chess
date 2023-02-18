package de.romanamo.chess.structure.tuple;

public class Couple<V, W> {
    private V first;
    private W second;

    public Couple() {
        this.first = null;
        this.second = null;
    }

    public Couple(V first, W second) {
        this.first = first;
        this.second = second;
    }

    public V getFirst() {
        return first;
    }

    public W getSecond() {
        return second;
    }
}
