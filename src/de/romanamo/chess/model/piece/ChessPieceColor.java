package de.romanamo.chess.model.piece;

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
}
