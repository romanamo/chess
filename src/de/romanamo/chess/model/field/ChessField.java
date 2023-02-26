package de.romanamo.chess.model.field;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.move.ChessMove;
import de.romanamo.chess.model.piece.ChessPiece;
import de.romanamo.chess.model.square.ChessSquare;
import de.romanamo.chess.model.square.GameSquare;
import de.romanamo.chess.structure.tuple.Couple;

import java.util.*;
import java.util.stream.Collectors;


public class ChessField implements Field<ChessField, Vec2d, ChessMove, ChessPiece, ChessSquare> {

    public final static String DEFAULT_DELIMITER = "|";

    public final static String DEFAULT_SPACING = " ";
    private final Map<Vec2d, ChessSquare> fieldMap;

    private final String delimiter;

    private final String spacing;

    public ChessField(Map<Vec2d, ChessSquare> fieldMap) {
        this.fieldMap = fieldMap;
        this.delimiter = ChessField.DEFAULT_DELIMITER;
        this.spacing = ChessField.DEFAULT_SPACING;
    }

    @Override
    public ChessSquare getValue(Vec2d id) {
        return this.fieldMap.get(id);
    }

    @Override
    public ChessPiece getPiece(Vec2d id) {
        return this.getValue(id).getFigure();
    }

    @Override
    public Set<Vec2d> getIdentifiers() {
        return this.fieldMap.keySet();
    }

    @Override
    public Set<ChessSquare> getValues() {
        return new HashSet<>(this.fieldMap.values());
    }

    @Override
    public String toString(boolean showIdentifiers) {
        //TODO
        Couple<Vec2d, Vec2d> dist = Vec2d.getCornerVectors(this.getIdentifiers());

        StringBuilder sb = new StringBuilder();

        for (int y = dist.getSecond().getY(); y >= dist.getFirst().getY(); y--) {
            //Creation of left vertical column of identifiers
            if (showIdentifiers) {
                sb.append(y).append(this.spacing);
            }
            for (int x = dist.getFirst().getX(); x <= dist.getSecond().getX(); x++) {

                Vec2d vec2d = new Vec2d(x, y);
                String symbol = this.getValue(vec2d).symbol();

                sb.append(delimiter).append(symbol);
            }
            sb.append(this.delimiter).append("\n");
        }
        //Creation of the horizontal bottom row of identifiers
        if (showIdentifiers) {
            StringBuilder bottom = new StringBuilder().append("     ");
            for (int x = dist.getFirst().getX(); x <= dist.getSecond().getX(); x++) {
                bottom.append( (char) (x - dist.getFirst().getX() + 'a')).append("         ");
            }
            sb.append(bottom);
        }

        return sb.toString();
    }

    @Override
    public List<ChessPiece> getFigures() {
        return this.fieldMap.values().stream().map(GameSquare::getFigure).filter(Objects::nonNull).toList();
    }

    @Override
    public Map<Vec2d, ChessPiece> getKeyFigureMap() {
        return this.fieldMap.keySet().stream()
                .filter(k -> !this.getValue(k).isEmpty())
                .collect(Collectors.toMap(k -> k , this::getPiece));
    }

    @Override
    public void setFigure(Vec2d id, ChessPiece figure) {
        this.getValue(id).setFigure(figure);
    }


}
