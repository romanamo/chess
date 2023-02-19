package de.romanamo.chess.model.square;

import de.romanamo.chess.model.piece.Piece;

public abstract class GameSquare<P extends Piece> implements Square<P>{


    protected P piece;

    public GameSquare() {
        this(null);
    }

    public GameSquare(P piece) {
        this.piece = piece;
    }

    @Override
    public P getFigure() {
        return this.piece;
    }
}
