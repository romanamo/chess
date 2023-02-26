package de.romanamo.chess.model.piece;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.model.move.ChessMove;

import java.util.List;

public class Bishop extends ChessPiece{
    public Bishop(ChessPieceColor color) {
        super(ChessPieceType.BISHOP, color);
    }

    @Override
    public List<ChessMove> getMoves(ChessField field, Vec2d start) {
        return this.getRotationalMoves(field, start, new Vec2d(1,1), 4, Math.PI / 2.0);
    }
}
