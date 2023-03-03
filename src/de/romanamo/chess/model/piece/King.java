package de.romanamo.chess.model.piece;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.model.move.ChessMove;

import java.util.*;
import java.util.stream.Collectors;

public class King extends ChessPiece {

    public King(ChessPieceColor color) {
        super(ChessPieceType.KING, color);
    }

    @Override
    public List<ChessMove> getMoves(ChessField field, Vec2d start, Set<Vec2d> leftOuts) {
        return null;
    }

    @Override
    public Set<Vec2d> getThreatSet(ChessField field, Vec2d pos, Set<Vec2d> leftOuts) {
        Set<Vec2d> threats = new HashSet<>();

        Vec2d moveVector = new Vec2d(1, 0);

        for (int i = 0; i < 8; i++) {
            double rotationalAngle = (Math.PI / 4.0) * i;

            Vec2d rotatedNormalizedMoveVector = moveVector.rotate(rotationalAngle);
            Vec2d nextVector = pos.add(rotatedNormalizedMoveVector);

            if (field.containsIdentifier(nextVector)) {
                ChessPiece piece = field.getPiece(nextVector);

                if (piece == null || piece.getChessPieceColor() != this.getChessPieceColor())
                    threats.add(nextVector);
            }
        }
        return threats;
    }
}
