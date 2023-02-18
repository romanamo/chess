package de.romanamo.chess.model.square;

import de.romanamo.chess.model.piece.Piece;

public class GameSquare<P extends Piece> implements Square<P>{

    public final static String DEFAULT_EMPTY = "▬";

    private P piece;

    public GameSquare() {
        this(null);
    }

    public GameSquare(P piece) {
        this.piece = piece;
    }
    @Override
    public String symbol() {
        if(this.isEmpty()) {
            return DEFAULT_EMPTY;
        }
        return this.getFigure().symbol();
    }

    @Override
    public P getFigure() {
        return this.piece;
    }
}
