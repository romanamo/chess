package de.romanamo.chess.model.piece;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.model.move.ChessMove;
import de.romanamo.chess.model.square.ChessSquare;

import java.util.*;

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

    public abstract List<ChessMove> getMoves(ChessField field, Vec2d start, Set<Vec2d> leftOuts);

    public List<ChessMove> getMoves(ChessField field) {
        Vec2d locationVector = this.getLocationVector(field);
        if (locationVector == null) {
            return new ArrayList<>();
        }
        return this.getMoves(field, locationVector, Set.of());
    }

    public abstract Set<Vec2d> getThreatSet(ChessField field, Vec2d pos, Set<Vec2d> leftOuts);

    protected Set<Vec2d> getRotationalThreats(ChessField field, Vec2d start,
                                              Vec2d moveVector, int iterations, double angle, Set<Vec2d> leftOuts) {
        Set<Vec2d> threats = new HashSet<>();
        for (int i = 0; i < iterations; i++) {
            double rotationalAngle = angle * i;

            Vec2d rotatedNormalizedMoveVector = moveVector.rotate(rotationalAngle);
            Vec2d currentVector = start.add(rotatedNormalizedMoveVector);

            while (field.containsIdentifier(currentVector)) {
                ChessPiece piece = field.getPiece(currentVector);
                if (piece == null || leftOuts.contains(currentVector)) {
                    threats.add(currentVector);
                } else {
                    if (piece.getChessPieceColor() != this.getChessPieceColor()) {
                        threats.add(currentVector);
                    }
                    break;
                }
                currentVector = currentVector.add(rotatedNormalizedMoveVector);
            }
        }
        return threats;
    }

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

    public boolean isSameColor(ChessPiece piece) {
        return this.chessPieceColor == piece.chessPieceColor;
    }

    public List<ChessPiece> fetchEnemyPieces(ChessField field) {
        return field.getFigures().stream().filter(p -> !this.isSameColor(p)).toList();
    }


    public ChessPieceColor getChessPieceColor() {
        return chessPieceColor;
    }

    public ChessPieceType getChessPieceType() {
        return chessPieceType;
    }
}
