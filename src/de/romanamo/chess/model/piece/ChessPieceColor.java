package de.romanamo.chess.model.piece;

/**
 * Class to describe the color of a {@link ChessPiece}
 *
 * In a standard Game of Chess the Color of the Pieces are black and white.
 *
 * @author romanamo
 * @version 1.0
 * @see ChessPiece
 */
public enum ChessPieceColor {
    BLACK('♔'),
    WHITE('♚');

    private final char UnicodeCodePoint;

    ChessPieceColor(char codePoint) {
        this.UnicodeCodePoint = codePoint;
    }

    public char getUnicodeCodePoint() {
        return UnicodeCodePoint;
    }

    public ChessPieceColor getRival() {
        return this == BLACK ? WHITE : BLACK;
    }
}
