package de.romanamo.chess.model.piece;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.model.move.ChessMove;

import java.util.List;
import java.util.Set;

public class Queen extends ChessPieceSlider {

    public Queen(ChessPieceColor color) {
        super(ChessPieceType.QUEEN, color);
    }

    @Override
    public List<ChessMove> getMoves(ChessField field, Vec2d start, Set<Vec2d> leftOuts) {
        return null;
    }

    @Override
    public Set<Vec2d> getSlidingVectors() {
        return getRotationalSlidingVectors(8, Math.PI / 4.0, new Vec2d(1,0));
    }
}
