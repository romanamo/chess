package de.romanamo.chess.model.square;

import de.romanamo.chess.model.piece.ChessPiece;

public class ChessSquare extends GameSquare<ChessPiece> {

    public ChessSquareColor chessSquareColor;

    public ChessSquare(ChessPiece piece, ChessSquareColor color) {
        super(piece);
        this.chessSquareColor = color;
    }

    public ChessSquare(ChessSquareColor color) {
        this(null, color);
    }

    @Override
    public String symbol() {
        if (this.isEmpty()) {
            return String.valueOf(chessSquareColor.getUnicodeCodePoint());
        }
        return this.piece.symbol();
    }
}
