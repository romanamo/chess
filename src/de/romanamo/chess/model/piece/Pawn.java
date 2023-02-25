package de.romanamo.chess.model.piece;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.model.move.ChessMove;

import java.util.List;

public class Pawn extends ChessPiece{


    public Pawn(ChessPieceColor color){
        super(ChessPieceType.PAWN, color);
    }

    @Override
    public List<ChessMove> getMoves(ChessField field, Vec2d v) {
        return null;
    }
}
