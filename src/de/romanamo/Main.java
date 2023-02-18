package de.romanamo;

import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.model.field.FieldFactory;
import de.romanamo.chess.model.piece.ChessPieceType;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FieldFactory factory = new FieldFactory();

        System.out.println(ChessPieceType.getMapping());

    }
}
