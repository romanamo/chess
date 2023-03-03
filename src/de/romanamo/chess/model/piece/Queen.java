package de.romanamo.chess.model.piece;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.model.move.ChessMove;

import java.util.List;
import java.util.Set;

public class Queen extends ChessPiece {

    public Queen(ChessPieceColor color) {
        super(ChessPieceType.QUEEN, color);
    }

    @Override
    public Set<Vec2d> getThreatSet(ChessField field, Vec2d pos, Set<Vec2d> leftOuts) {
        return this.getRotationalThreats(field, pos, new Vec2d(1, 0), 8, (Math.PI / 4.0), leftOuts);
    }

    @Override
    public List<ChessMove> getMoves(ChessField field, Vec2d start, Set<Vec2d> leftOuts) {
        return null;
    }
}
