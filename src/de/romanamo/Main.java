package de.romanamo;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.model.piece.ChessPieceColor;
import de.romanamo.chess.model.piece.Knight;
import de.romanamo.chess.util.FileHandling;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        ChessField field = FileHandling.loadChessFen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        field = FileHandling.loadChessFen("r1b1k1nr/p2p1pNp/n2B4/1p1NP2P/6P1/3P1Q2/P1P1K3/q5b1");

        Knight n = new Knight(ChessPieceColor.WHITE);

        n.getMoves(null, new Vec2d(1,2)).forEach(System.out::println);
        System.out.println(field.toString(true));

    }
}
