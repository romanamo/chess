package de.romanamo.chess.model.piece;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum ChessPieceType{

    KING('k', 1000, 0),
    QUEEN('q', 9, 1),
    ROOK('r', 5, 2),
    BISHOP('b', 3, 3),
    KNIGHT('n', 3, 4),
    PAWN('p', 1, 5);

    private final char descriptor;

    private final int value;

    private final int priority;

    ChessPieceType(char descriptor, int value, int priority) {
        this.descriptor = descriptor;
        this.value = value;
        this.priority = priority;
    }

    public int getValue() {
        return value;
    }

    public int getPriority() {
        return priority;
    }


    @Override
    public String toString() {
        return "ChessPieceType{" +
                "descriptor=" + descriptor +
                ", value=" + value +
                ", priority=" + priority +
                '}';
    }

    public static Map<String, ChessPieceType> getMapping() {
        return Arrays.stream(ChessPieceType.values())
                .collect(Collectors.toMap(t -> String.valueOf(t.descriptor), t -> t));
    }
}
