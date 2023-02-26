package de.romanamo;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.model.piece.ChessPiece;
import de.romanamo.chess.util.FileHandling;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        ChessField field = FileHandling.loadChessFen("rnbqkbnr/pppppppp/8/2P1p3/3P4/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");

        ChessPiece piece = field.getPiece(new Vec2d(2,1));

        piece.getMoves(field, new Vec2d(4, 4)).forEach(System.out::println);
        System.out.println(field.toString(true));

    }
}
