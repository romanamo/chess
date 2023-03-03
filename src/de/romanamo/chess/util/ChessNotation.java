package de.romanamo.chess.util;

import de.romanamo.chess.math.Vec2d;

public abstract class ChessNotation {

    public static final String START_BOARD_FEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

    public static final String EMPTY_BOARD_FEN = "8/8/8/8/8/8/8/8 w - - 0 1";

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
