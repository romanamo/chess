package de.romanamo.chess.util;

import de.romanamo.chess.math.Vec2d;

public abstract class ChessNotation {

    /**
     * Translates a {@link Vec2d Vector} into the algebraic Chess Notation
     *
     * @param v Vector to translate
     * @return algebraic Chess Notation of given Vector
     */
    public static String translateVector(Vec2d v) {
        return (char) ('a' - 1 + v.getX()) + Integer.toString(v.getY());
    }
}
