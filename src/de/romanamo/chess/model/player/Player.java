package de.romanamo.chess.model.player;

import de.romanamo.chess.model.field.Field;
import de.romanamo.chess.model.move.Move;
import de.romanamo.chess.model.piece.Piece;
import de.romanamo.chess.model.square.Square;

import java.util.Collection;
import java.util.List;

public interface Player<
        F extends Field<F,K,M,P,S>,
        K,
        M extends Move<F,K,M,P,S>,
        P extends Piece<F,K,M,P,S>,
        S extends Square<? extends P>> {

    boolean hasWon(F field);

    default List<P> fetchPieces(F field) {
        return field.getFigures().stream().filter(this::controlsPiece).toList();
    }

    default List<P> fetchPieces(Collection<P> pieces) {
        return pieces.stream().filter(this::controlsPiece).toList();
    }

    boolean controlsPiece(P piece);
}

