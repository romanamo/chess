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
            String back = String.valueOf(chessSquareColor.getUnicodeCodePoint());
            return back + " " + back;
        }
        return this.piece.symbol();
    }

    @Override
    public void setFigure(ChessPiece figure) {
        this.piece = figure;
    }
}
