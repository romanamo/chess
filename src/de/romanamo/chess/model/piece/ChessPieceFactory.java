package de.romanamo.chess.model.piece;

public class ChessPieceFactory {

    public static ChessPiece getInstance(ChessPieceType type, ChessPieceColor color) {
        switch (type) {
            case KING -> {
                return new King(color);
            }
            case QUEEN -> {
                return new Queen(color);
            }
            case ROOK -> {
                return new Rook(color);
            }
            case BISHOP -> {
                return new Bishop(color);
            }
            case KNIGHT -> {
                return new Knight(color);
            }
            case PAWN -> {
                return new Pawn(color);
            }
            default ->
            {
                throw new IllegalArgumentException("Requested piece does not exit");
            }
        }

    }
}
