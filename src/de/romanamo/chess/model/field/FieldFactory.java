package de.romanamo.chess.model.field;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.square.ChessSquare;

import java.util.HashMap;
import java.util.Map;

public class FieldFactory {

    public ChessField getChessField() {

        Map<Vec2d, ChessSquare> chessField = new HashMap<>();
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                chessField.put(new Vec2d(i, j), new ChessSquare());
            }
        }
        return new ChessField(chessField);

    }
}
