package de.romanamo.chess.model.player;

import de.romanamo.chess.model.field.Field;
import de.romanamo.chess.model.piece.Piece;
import de.romanamo.chess.model.square.Square;

import java.util.Collection;
import java.util.List;

public interface Player<P extends Piece, V extends Square<P>, K, F extends Field<K, V, P>> {

    boolean hasWon(F field);

    default List<P> fetchPieces(F field) {
        return field.getFigures().stream().filter(this::controlsPiece).toList();
    }

    default List<P> fetchPieces(Collection<P> pieces) {
        return pieces.stream().filter(this::controlsPiece).toList();
    }

    boolean controlsPiece(P piece);
}

