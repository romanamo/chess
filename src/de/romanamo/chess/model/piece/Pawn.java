package de.romanamo.chess.model.piece;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.model.move.ChessMove;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends ChessPiece{


    public Pawn(ChessPieceColor color){
        super(ChessPieceType.PAWN, color);
    }

    private Vec2d getNormalizedDirectionVector() {
        return this.getChessPieceColor() == ChessPieceColor.BLACK ? new Vec2d(0, -1) : new Vec2d(0, 1);
    }

    @Override
    public List<ChessMove> getMoves(ChessField field, Vec2d start) {
        List<ChessMove> moves = new ArrayList<>();

        Vec2d normalizedDirectionVector = this.getNormalizedDirectionVector();
        Vec2d nextVector = start.add(normalizedDirectionVector);

        double angle = (Math.PI / 4.0);
        //TODO add en passant
        //TODO add attack
        if(field.containsIdentifier(nextVector) && field.getValue(nextVector).isEmpty()) {
            moves.add(new ChessMove(start, nextVector));
        }
        for(int i : new int[]{-1, 1}) {
            Vec2d attackVector = start.add(normalizedDirectionVector.rotate(angle * i));
            ChessPiece piece = field.getPiece(attackVector);

            if(piece != null && piece.getChessPieceColor() != this.getChessPieceColor()) {
                moves.add(new ChessMove(start, attackVector));
            }
        }

        return moves;
    }
}
