package de.romanamo.chess.util;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.model.field.FieldFactory;
import de.romanamo.chess.model.piece.ChessPieceColor;
import de.romanamo.chess.model.piece.ChessPieceFactory;
import de.romanamo.chess.model.piece.ChessPieceType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;

public class FileHandling {

    public static ChessField loadChessFenFromPath(final String filePath) throws IOException {

        Stream<String> lines = Files.lines(Paths.get(filePath));
        Map<String, ChessPieceType> pieceMapping = ChessPieceType.getMapping(true);

        lines.close();

        return null;
    }

    public static ChessField loadChessFen(final String fen) {
        String[] fenParts = fen.split("\\s|/");

        ChessField chessField = FieldFactory.getChessField();
        Map<String, ChessPieceType> pieceTypeMap = ChessPieceType.getMapping(true);

        for (int y = 8; y >= 1; y--) {
            int x = 1;
            char[] lineParts = fenParts[Math.abs(8 - y)].toCharArray();

            for (char part : lineParts) {
                if (Character.isDigit(part)) {
                    int advance = Integer.parseInt(String.valueOf(part));
                    x += advance;
                } else if (Character.isLetter(part)) {

                    ChessPieceColor color = Character.isUpperCase(part) ? ChessPieceColor.WHITE : ChessPieceColor.BLACK;
                    ChessPieceType type = pieceTypeMap.get(String.valueOf(Character.toLowerCase(part)));

                    Vec2d pos = new Vec2d(x, y);
                    chessField.setFigure(pos, ChessPieceFactory.getInstance(type, color));

                    x++;
                }

            }
        }
        return chessField;
    }

    public static boolean isValidFen(final String fen) {
        return true;
    }


}
