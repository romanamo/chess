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
    public List<ChessMove> getMoves(ChessField field, Vec2d start) {
        List<ChessMove> moves = new ArrayList<>();

        Vec2d moveVector1 = new Vec2d(1, 3);
        Vec2d moveVector2 = new Vec2d(-1, 3);

        for (int i = 0; i < 4; i++) {
            double angle = (Math.PI / 2.0) * i;

            Vec2d rotatedMoveVector1 = moveVector1.rotate(angle);
            Vec2d rotatedMoveVector2 = moveVector2.rotate(angle);

            for (Vec2d bounds : new Vec2d[]{rotatedMoveVector1, rotatedMoveVector2}) {
                if (field.containsIdentifier(bounds)) {
                    ChessPiece piece = field.getPiece(bounds);
                    if(piece == null || piece.getChessPieceColor() == this.getChessPieceColor()) {
                        moves.add(new ChessMove(start, bounds));
                    }

                }
            }
        }
        return moves;
    }
}
