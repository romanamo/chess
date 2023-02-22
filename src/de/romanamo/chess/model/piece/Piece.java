package de.romanamo.chess.model.piece;

import de.romanamo.chess.model.Symbolizable;
import de.romanamo.chess.model.field.Field;
import de.romanamo.chess.model.move.Move;
import de.romanamo.chess.model.square.Square;

import java.util.List;

public interface Piece<
        F extends Field<F,K,M,P,S>,
        K,
        M extends Move<F,K,M,P,S>,
        P extends Piece<F,K,M,P,S>,
        S extends Square<? extends P>> extends Symbolizable {

    int getValue();

    List<M> getMoves(F field);


}
