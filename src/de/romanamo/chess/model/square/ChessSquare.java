package de.romanamo.chess.model.square;

import de.romanamo.chess.model.piece.ChessPiece;

public class ChessSquare extends GameSquare<ChessPiece>{

    public ChessSquare(ChessPiece piece) {
        super(piece);
    }

    public ChessSquare() {
        super();
    }
}
