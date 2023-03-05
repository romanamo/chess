package de.romanamo.chess.model.piece;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.field.ChessField;

import java.util.HashSet;
import java.util.Set;

/**
 * Class to describe a sliding Piece.
 * <p>
 * sliding pieces are able to slide into different directions and stop their slide
 * until they hit another Piece, or they reach edge of the board.
 * <p>
 * For a usual game of chess the Bishop, the Rook and the Queen can be classified as a "Slider",
 * since the Rook can slide vertically and horizontally, the Bishop into both diagonal Directions
 * and the Queen combines the directions of the Rook and the Bishop.
 * <p>
 * For optimal Calculation of a Checkmate the Code for "Sliders" needs to be handled differently as for
 * the other Pieces.
 *
 * @author romanamo
 * @version 1.0
 * @see ChessPiece
 * @see Queen
 * @see Bishop
 * @see Rook
 */
public abstract class ChessPieceSlider extends ChessPiece {

    /**
     * Constructs a basic Slider.
     *
     * @param type  Type of the Piece,
     * @param color Color of the Piece
     */
    public ChessPieceSlider(ChessPieceType type, ChessPieceColor color) {
        super(type, color);
    }

    /**
     * Calculates all {@link Vec2d Vectors} that specify the
     * direction the Piece is able to slide to.
     *
     * @return {@link Set} of all possible directional Vectors
     */
    public abstract Set<Vec2d> getSlidingVectors();

    /**
     * Calculates rotational Sliding {@link Vec2d Vectors} by taking an
     * initial Vector and rotating it by the given {@code angle},
     * {@code iterations} times.
     *
     * @param n       amount of iterations
     * @param angle   angle to rotate
     * @param initial initial Vector
     * @return a {@link Set} of rotated Vectors
     */
    public static Set<Vec2d> getRotationalSlidingVectors(int n, double angle, Vec2d initial) {
        Set<Vec2d> slidingVectors = new HashSet<>();
        //This still can be enhanced by avoiding unnecessary multiple circulations
        for (int i = 0; i < n; i++) {
            slidingVectors.add(initial.rotate(angle * i));
        }
        return slidingVectors;
    }

    /**
     * Calculates all {@link Vec2d Vectors} that are threatened by this Piece,
     * towards the specified directions.
     *
     * @param field     playing field
     * @param start     position of the Piece
     * @param direction Directions
     * @param leftOuts  Vectors that should not be considered
     * @return a {@link Set} of all threatened Vectors of specified direction
     */
    public static Set<Vec2d> getSlidingThreats(ChessField field, Vec2d start, Vec2d direction,
                                               ChessPieceColor ownColor, Set<Vec2d> leftOuts) {
        Set<Vec2d> threats = new HashSet<>();


        Vec2d currentVector = start.add(direction);

        //Check if the current Vector being considered is still inside the bounds of the field
        while (field.containsIdentifier(currentVector)) {
            ChessPiece piece = field.getPiece(currentVector);

            if (piece == null || leftOuts.contains(currentVector)) {
                //If the current Square is empty or the Square should not be considered, it will be added
                threats.add(currentVector);
            } else {
                if (piece.getChessPieceColor() != ownColor) {
                    //If the threatened Piece belongs to the enemy, it will be added
                    threats.add(currentVector);
                }
                //Piece cannot be slided any further
                break;
            }
            currentVector = currentVector.add(direction);
        }


        return threats;
    }

    @Override
    public Set<Vec2d> getThreatSet(ChessField field, Vec2d start, Set<Vec2d> leftOuts) {
        Set<Vec2d> threats = new HashSet<>();
        for (Vec2d direction : this.getSlidingVectors()) {
            threats.addAll(getSlidingThreats(field, start, direction, this.getChessPieceColor(), leftOuts));
        }
        return threats;
    }
}
