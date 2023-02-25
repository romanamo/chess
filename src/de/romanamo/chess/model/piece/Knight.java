package de.romanamo.chess.model.piece;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.model.move.ChessMove;

import java.util.ArrayList;
import java.util.List;

public class Knight extends ChessPiece {

    public Knight(ChessPieceColor color) {
        super(ChessPieceType.KNIGHT, color);
    }

    @Override
    public List<ChessMove> getMoves(ChessField field, Vec2d v) {
        List<ChessMove> moves = new ArrayList<>();

        Vec2d moveVector1 = new Vec2d(1, 2);
        Vec2d moveVector2 = new Vec2d(-1, 2);

        //TODO check if vector not on field

        for (int i = 0; i < 4; i++) {
            double angle = (Math.PI / 2.0) * i;

            //TODO check if rotated vector is not on field
            moves.add(new ChessMove(moveVector1, moveVector1.rotate(angle)));
            //moves.add(new ChessMove(moveVector2, moveVector2.rotate(angle)));
        }

        return moves;
    }
}
