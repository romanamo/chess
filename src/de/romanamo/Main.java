package de.romanamo;

import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.model.move.ChessMove;
import de.romanamo.chess.model.move.MoveNotApplicableException;
import de.romanamo.chess.model.piece.ChessPiece;
import de.romanamo.chess.model.piece.ChessPieceColor;
import de.romanamo.chess.util.FileHandling;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException, MoveNotApplicableException {

        ChessField field = FileHandling.loadChessFen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");


        List<ChessPiece> whitePieces = field.getFigures().stream().filter(p -> p.getChessPieceColor() == ChessPieceColor.WHITE).toList();
        Random r = new Random(123);

        for (int i = 0; i < 50; i++) {
            ChessPiece piece = whitePieces.get(r.nextInt(whitePieces.size()));
            ChessMove move = piece.getMoves(field).stream().findFirst().orElse(null);

            if (move == null) {
                continue;
            }
            System.out.println(field.toString(true));
            System.out.println(piece.getMoves(field));
            move.doMove(field);

        }


    }
}
