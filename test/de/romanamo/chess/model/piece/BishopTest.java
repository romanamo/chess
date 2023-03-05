package de.romanamo.chess.model.piece;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.util.ChessNotation;
import de.romanamo.chess.util.FileHandling;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {

    private ChessField field;

    @BeforeEach
    public void initializeField() {
        this.field = FileHandling.loadChessFen(ChessNotation.EMPTY_BOARD_FEN);
    }

    @Test
    void getThreatSet() {
        Bishop bishop = new Bishop(ChessPieceColor.WHITE);
        this.field.setFigure(new Vec2d(4, 4), bishop);

        Set<Vec2d> threats = bishop.getThreatSet(field, new Vec2d(4,4), Set.of());
        threats.forEach(t -> field.setFigure(t, new Knight(ChessPieceColor.BLACK)));

        System.out.println(field.toString(true));

    }
}