package de.romanamo.chess.model.piece;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.model.move.ChessMove;
import de.romanamo.chess.model.square.ChessSquare;

import java.util.List;

public class ChessPiece implements Piece<ChessField, Vec2d, ChessMove, ChessPiece, ChessSquare> {

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

        return " " + (char) (point + priority) + " ";
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public List<ChessMove> getMoves(ChessField field) {
        return null;
    }


    public ChessPieceColor getChessPieceColor() {
        return chessPieceColor;
    }

    public ChessPieceType getChessPieceType() {
        return chessPieceType;
    }
}
