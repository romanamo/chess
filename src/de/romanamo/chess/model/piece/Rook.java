package de.romanamo.chess.model.piece;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.model.move.ChessMove;

import java.util.List;

public class Rook extends ChessPiece {

    public Rook(ChessPieceColor color) {
        super(ChessPieceType.ROOK, color);
    }

    @Override
    public List<ChessMove> getMoves(ChessField field, Vec2d start) {
        return this.getRotationalMoves(field, start, new Vec2d(0,1), 4, Math.PI / 2.0);
    }
}
