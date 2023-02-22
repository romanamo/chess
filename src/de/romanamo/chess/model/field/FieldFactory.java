package de.romanamo.chess.model.field;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.square.ChessSquare;
import de.romanamo.chess.model.square.ChessSquareColor;

import java.util.HashMap;
import java.util.Map;

public class FieldFactory {

    public static ChessField getChessField() {

        Map<Vec2d, ChessSquare> chessField = new HashMap<>();
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                ChessSquareColor squareColor;
                if((i + j) % 2 == 0) {
                    squareColor = ChessSquareColor.BLACK;
                }
                else {
                    squareColor = ChessSquareColor.WHITE;
                }
                chessField.put(new Vec2d(i, j), new ChessSquare(squareColor));
            }
        }
        return new ChessField(chessField);

    }
}
