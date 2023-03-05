package de.romanamo.chess.model.piece;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.util.ChessNotation;
import de.romanamo.chess.util.FileHandling;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class KingPinTest {

    @Test
    public void StraightPinTest() {
        ChessField field = FileHandling.loadChessFen(ChessNotation.EMPTY_BOARD_FEN);

        King k = new King(ChessPieceColor.WHITE);
        Knight knight = new Knight(ChessPieceColor.WHITE);
        Rook rook = new Rook(ChessPieceColor.BLACK);

        field.setFigure(new Vec2d(4, 1), k);
        field.setFigure(new Vec2d(4, 3), knight);
        field.setFigure(new Vec2d(4, 7), rook);

        assertTrue(k.getPinnedLocations(field, new Vec2d(4, 1)).contains(new Vec2d(4, 3)));
    }

    @Test
    public void NoStraightPinThroughTwoPiecesTest() {
        ChessField field = FileHandling.loadChessFen("8/8/4K3/8/4N3/4N3/8/4q3 w - - 0 1");

        King king = (King) field.getPiece(new Vec2d(5, 6));
        Set<Vec2d> pinned = king.getPinnedLocations(field, new Vec2d(5, 5));
        assertTrue(pinned.isEmpty());
    }

    @Test
    public void NoPinTest() {
        ChessField field = FileHandling.loadChessFen("4K3/8/8/8/8/8/8/4q3 w - - 0 1");

        King king = (King) field.getPiece(new Vec2d(5, 8));
        Set<Vec2d> pinned = king.getPinnedLocations(field, new Vec2d(5, 8));
        assertTrue(pinned.isEmpty());
    }
}
