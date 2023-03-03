package de.romanamo.chess.model.move;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.model.piece.ChessPiece;
import de.romanamo.chess.model.square.ChessSquare;

public class ChessMove implements Move<ChessField, Vec2d, ChessMove, ChessPiece, ChessSquare>{

    private ChessPiece capturedPiece;

    private final Vec2d start;

    private final Vec2d end;

    public ChessMove(Vec2d start, Vec2d end) {
        this.start = start;
        this.end = end;
    }


    @Override
    public void doMove(ChessField field) throws MoveNotApplicableException {
        ChessPiece piece = field.getPiece(this.start);
        field.setFigure(this.start, null);
        field.setFigure(this.end, piece);
    }

    @Override
    public void undoMove(ChessField field) throws MoveNotApplicableException {

    }

    public Vec2d getStart() {
        return start;
    }

    public Vec2d getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "ChessMove{" +
                "capturedPiece=" + capturedPiece +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
