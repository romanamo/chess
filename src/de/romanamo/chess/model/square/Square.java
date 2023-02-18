package de.romanamo.chess.model.square;

import de.romanamo.chess.model.Symbolizable;

public interface Square<T> extends Symbolizable {

    T getFigure();

    default boolean isEmpty() {
        return this.getFigure() == null;
    }

}
