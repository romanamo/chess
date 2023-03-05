package de.romanamo.chess.model.piece;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.model.move.ChessMove;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pawn extends ChessPiece {


    public Pawn(ChessPieceColor color) {
        super(ChessPieceType.PAWN, color);
    }

    private Vec2d getNormalizedDirectionVector() {
        return this.getChessPieceColor() == ChessPieceColor.BLACK ? new Vec2d(0, -1) : new Vec2d(0, 1);
    }

    @Override
    public List<ChessMove> getMoves(ChessField field, Vec2d start, Set<Vec2d> leftOuts) {
        //Set<Vec2d> threats = new HashSet<>();
        //
        //Vec2d normalizedDirectionVector = this.getNormalizedDirectionVector();
        //Vec2d nextVector = pos.add(normalizedDirectionVector);
        //
        //double angle = (Math.PI / 4.0);
        ////TODO add en passant
        //if(field.containsIdentifier(nextVector) && field.getValue(nextVector).isEmpty()) {
        //    threats.add(nextVector);
        //}
        //for(int i : new int[]{-1, 1}) {
        //    Vec2d attackVector = pos.add(normalizedDirectionVector.rotate(angle * i));
        //    if(field.containsIdentifier(attackVector)) {
        //        ChessPiece piece = field.getPiece(attackVector);
        //
        //        if(piece != null && piece.getChessPieceColor() != this.getChessPieceColor()) {
        //            threats.add(attackVector);
        //        }
        //    }
        //
        //}
        //
        //return threats;
        return null;
    }

    @Override
    public Set<Vec2d> getThreatSet(ChessField field, Vec2d pos, Set<Vec2d> leftOuts) {
        Set<Vec2d> threats = new HashSet<>();

        Vec2d normalizedDirectionVector = this.getNormalizedDirectionVector();

        double angle = (Math.PI / 4.0);
        for (int i : new int[]{-1, 1}) {
            Vec2d attackVector = pos.add(normalizedDirectionVector.rotate(angle * i));
            if (field.containsIdentifier(attackVector)) {
                ChessPiece piece = field.getPiece(attackVector);
                if (piece != null && piece.getChessPieceColor() != this.getChessPieceColor()) {
                    threats.add(attackVector);
                }
            }
        }
        return threats;
    }
}
