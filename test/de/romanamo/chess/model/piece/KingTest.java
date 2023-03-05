package de.romanamo.chess.model.piece;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.model.move.ChessMove;
import de.romanamo.chess.util.ChessNotation;
import de.romanamo.chess.util.FileHandling;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class KingTest {

    private ChessField field;

    @BeforeEach
    public void initializeField() {
        this.field = FileHandling.loadChessFen(ChessNotation.EMPTY_BOARD_FEN);
    }

    @Test
    public void KnightCheckTest() {
        King k  = new King(ChessPieceColor.WHITE);
        field.setFigure(new Vec2d(4, 4), k);
        Set<Vec2d> threats = k.getThreatSet(field, new Vec2d(4, 4), Set.of());

        threats.forEach(t -> field.setFigure(t, new Knight(ChessPieceColor.BLACK)));

        System.out.println(field.toString(true));
    }

    @Test
    public void KingWalkTest() {
        King k  = new King(ChessPieceColor.WHITE);
        field.setFigure(new Vec2d(4, 4), k);
        Rook r  = new Rook(ChessPieceColor.BLACK);
        field.setFigure(new Vec2d(1, 4), r);
        Rook r2  = new Rook(ChessPieceColor.BLACK);
        field.setFigure(new Vec2d(5, 1), r2);

        List<ChessMove> threats = k.getMoves(field);

        threats.forEach(t -> field.setFigure(t.getEnd(), new Knight(ChessPieceColor.BLACK)));

        System.out.println(field.toString(true));
    }
    @Test
    public void checkingEnemies() {
        King k  = new King(ChessPieceColor.WHITE);
        field.setFigure(new Vec2d(4, 4), k);
        Rook r  = new Rook(ChessPieceColor.BLACK);
        field.setFigure(new Vec2d(1, 4), r);
        Rook r2  = new Rook(ChessPieceColor.BLACK);
        field.setFigure(new Vec2d(4, 8), r2);


        System.out.println(field.toString(true));

        assertEquals(Set.of(r, r2), k.getCheckingEnemies(field));
    }
}
