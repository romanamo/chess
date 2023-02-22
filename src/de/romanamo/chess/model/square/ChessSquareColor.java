package de.romanamo.chess.model.square;

public enum ChessSquareColor {

    BLACK('█'),
    WHITE('░');

    private final char UnicodeCodePoint;

    ChessSquareColor(char codePoint) {
        this.UnicodeCodePoint = codePoint;
    }

    public char getUnicodeCodePoint() {
        return UnicodeCodePoint;
    }
}
