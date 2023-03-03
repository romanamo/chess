package de.romanamo.chess.model.piece;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.model.move.ChessMove;
import de.romanamo.chess.util.ChessNotation;
import de.romanamo.chess.util.FileHandling;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


class KnightTest {

    private ChessField field;

    @BeforeEach
    public void initializeField() {
        this.field = FileHandling.loadChessFen(ChessNotation.EMPTY_BOARD_FEN);

    }

    @Test
    public void emptyFieldTest() {
        Knight knight = new Knight(ChessPieceColor.WHITE);
        this.field.setFigure(new Vec2d(4, 4), knight);

        Set<Vec2d> moveVectors = Set.of(
                new Vec2d(6, 5),
                new Vec2d(5, 6),
                new Vec2d(3, 6),
                new Vec2d(2, 5),
                new Vec2d(2, 3),
                new Vec2d(3, 2),
                new Vec2d(5, 2),
                new Vec2d(6, 3));

        Set<Vec2d> vec2dSet = knight.getThreatSet(field, new Vec2d(4,4), Set.of());
        System.out.println(vec2dSet);
        assertEquals(moveVectors, vec2dSet);
    }
}