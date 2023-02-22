package de.romanamo;

import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.util.FileHandling;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        ChessField field = FileHandling.loadChessFen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        field = FileHandling.loadChessFen("4k2r/6r1/8/8/8/8/3R4/R3K3 w Qk - 0 1");
        System.out.println(field.toString(true));

    }
}
