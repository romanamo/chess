package de.romanamo.chess.model.piece;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.model.move.ChessMove;
import de.romanamo.chess.model.square.ChessSquare;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class ChessPiece implements Piece<ChessField, Vec2d, ChessMove, ChessPiece, ChessSquare> {

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

    public abstract List<ChessMove> getMoves(ChessField field, Vec2d start);

    public List<ChessMove> getMoves(ChessField field) {
        Vec2d locationVector = this.getLocationVector(field);
        if (locationVector == null) {
            return new ArrayList<>();
        }
        return this.getMoves(field, locationVector);
    }

    protected List<ChessMove> getRotationalMoves(ChessField field, Vec2d start,
                                                 Vec2d moveVector, int iterations, double angle) {
        List<ChessMove> moves = new ArrayList<>();
        for (int i = 0; i < iterations; i++) {
            double rotationalAngle = angle * i;

            Vec2d rotatedNormalizedMoveVector = moveVector.rotate(rotationalAngle);
            Vec2d currentVector = start.add(rotatedNormalizedMoveVector);

            while (field.containsIdentifier(currentVector)) {
                ChessPiece piece = field.getPiece(currentVector);
                if (piece == null) {
                    moves.add(new ChessMove(start, currentVector));
                } else {
                    if (piece.getChessPieceColor() != this.getChessPieceColor()) {
                        moves.add(new ChessMove(start, currentVector));
                    }
                    break;
                }
                currentVector = currentVector.add(rotatedNormalizedMoveVector);
            }
        }
        return moves;
    }

    //TODO write
    public Vec2d getLocationVector(ChessField field) {
        Map<Vec2d, ChessPiece> figureMap = field.getKeyFigureMap();
        return figureMap.keySet().stream().filter(k -> figureMap.get(k) == this).findFirst().orElse(null);
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


    public ChessPieceColor getChessPieceColor() {
        return chessPieceColor;
    }

    public ChessPieceType getChessPieceType() {
        return chessPieceType;
    }
}
