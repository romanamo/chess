package de.romanamo.chess.model.player;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.model.move.ChessMove;
import de.romanamo.chess.model.piece.ChessPiece;
import de.romanamo.chess.model.piece.ChessPieceColor;
import de.romanamo.chess.model.square.ChessSquare;

public class ChessPlayer implements Player<ChessField, Vec2d, ChessMove, ChessPiece, ChessSquare> {

    public ChessPieceColor playerColor;

    public ChessPlayer(ChessPieceColor playerColor) {
        this.playerColor = playerColor;
    }

    @Override
    public boolean hasWon(ChessField field) {
        return false;
    }

    @Override
    public boolean controlsPiece(ChessPiece piece) {
        return piece.getChessPieceColor() == this.playerColor;
    }
}