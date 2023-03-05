package de.romanamo.chess.model.player;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.model.move.ChessMove;
import de.romanamo.chess.model.piece.*;
import de.romanamo.chess.model.square.ChessSquare;

import java.util.HashSet;
import java.util.Set;

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

    @Override
    public Set<ChessMove> getMoves(ChessField field) {
        King king = (King) this.fetchPieces(field).stream().filter(p -> p.getChessPieceType() == ChessPieceType.KING).findAny().orElse(null);

        //TODO change later to give all piece moves
        if(king == null) return Set.of();

        Set<Vec2d> captureMask = new HashSet<>();
        Set<Vec2d> pushMask = new HashSet<>();

        Set<ChessPiece> checkingPieces = king.getCheckingEnemies(field);

        if(checkingPieces.size() == 1) {

            ChessPiece checkingPiece = checkingPieces.stream().findFirst().orElse(null);
            captureMask.add(checkingPiece.getLocation(field));

            if(checkingPiece instanceof ChessPieceSlider slider) {

                Vec2d sliderVector = slider.getLocation(field);
                Vec2d kingVector = king.getLocation(field);
                Vec2d between = sliderVector.add(kingVector.scale(-1)).normalize();

                pushMask.addAll(ChessPieceSlider.getSlidingThreats(field, sliderVector, between, king.getChessPieceColor(),  Set.of()));
            }
        } else if (checkingPieces.size() > 1) {
            return null; // return legal king moves
        }
        return null;
    }


}