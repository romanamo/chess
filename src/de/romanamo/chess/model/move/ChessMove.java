package de.romanamo.chess.model.move;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.model.piece.ChessPiece;
import de.romanamo.chess.model.square.ChessSquare;

public class ChessMove implements Move<ChessField, Vec2d, ChessMove, ChessPiece, ChessSquare>{

    private ChessPiece capturedPiece;

    private Vec2d start;

    private Vec2d end;


    @Override
    public void doMove(ChessField field) throws MoveNotApplicableException {

    }

    @Override
    public void undoMove(ChessField field) throws MoveNotApplicableException {

    }
}
