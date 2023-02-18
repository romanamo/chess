package de.romanamo.chess.model.piece;

public class ChessPiece implements Piece {

    private final int value;
    private final ChessPieceColor chessPieceColor;
    private final ChessPieceType chessPieceType;

    /**
     * Constructs a basic Chess Piece
     *
     * @param type  Type of the Piece,
     * @param color Color of the Piece
     */
    public ChessPiece(ChessPieceType type, ChessPieceColor color) {
        this.chessPieceType = type;
        this.chessPieceColor = color;
        this.value = type.getValue();
    }

    @Override
    public String symbol() {
        char point = this.chessPieceColor.getUnicodeCodePoint();
        int priority = this.chessPieceType.getPriority();

        return String.valueOf((char) (point + priority));
    }

    @Override
    public int getValue() {
        return this.value;
    }
}
