package de.romanamo.chess.model.piece;

import de.romanamo.chess.math.Vec2d;
import de.romanamo.chess.model.field.ChessField;
import de.romanamo.chess.model.move.ChessMove;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class King extends ChessPiece {

    public King(ChessPieceColor color) {
        super(ChessPieceType.KING, color);
    }

    public Set<Vec2d> getEnemyThreats(ChessField field, Set<Vec2d> leftOuts) {
        return this.fetchEnemyPieces(field)
                .stream().flatMap(s -> s.getThreatSet(field, s.getLocation(field), leftOuts).stream())
                .collect(Collectors.toSet());
    }

    public Set<ChessPiece> getCheckingEnemies(ChessField field) {
        Vec2d location = this.getLocation(field);
        List<ChessPiece> enemies = this.fetchEnemyPieces(field);

        return enemies.stream()
                .filter(e -> e.getThreatSet(field, e.getLocation(field), Set.of()).contains(location))
                .collect(Collectors.toSet());
    }


    @Override
    public List<ChessMove> getMoves(ChessField field, Vec2d start, Set<Vec2d> leftOuts) {
        Set<Vec2d> options = this.getThreatSet(field, start, Set.of());
        Set<Vec2d> enemyThreats = this.getEnemyThreats(field, Set.of(this.getLocation(field)));

        options.removeAll(enemyThreats);

        return options.stream().map(opt -> new ChessMove(start, opt)).toList();
    }

    @Override
    public Set<Vec2d> getThreatSet(ChessField field, Vec2d pos, Set<Vec2d> leftOuts) {
        Set<Vec2d> threats = new HashSet<>();

        Vec2d moveVector = new Vec2d(1, 0);

        for (int i = 0; i < 8; i++) {
            double rotationalAngle = (Math.PI / 4.0) * i;

            Vec2d rotatedNormalizedMoveVector = moveVector.rotate(rotationalAngle);
            Vec2d nextVector = pos.add(rotatedNormalizedMoveVector);

            if (field.containsIdentifier(nextVector)) {
                ChessPiece piece = field.getPiece(nextVector);

                if (piece == null || piece.getChessPieceColor() != this.getChessPieceColor())
                    threats.add(nextVector);
            }
        }
        return threats;
    }

    public Set<Vec2d> getPinnedLocations(ChessField field, Vec2d pos) {
        Set<Vec2d> pins = new HashSet<>();
        Vec2d kingPos = this.getLocation(field);

        ChessPieceColor enemyColor = this.getChessPieceColor().getRival();

        Set<Vec2d> directions = ChessPieceSlider.getRotationalSlidingVectors(8, Math.PI / 2.0, new Vec2d(1, 0));

        Set<Vec2d> enemySliderPos = field.getFigures().stream()
                .filter(p -> !p.isSameColor(this) && p instanceof ChessPieceSlider)
                .map(p -> p.getLocation(field)).collect(Collectors.toSet());

        for (Vec2d sliderPos : enemySliderPos) {
            ChessPieceSlider sliderPiece = (ChessPieceSlider) field.getPiece(sliderPos);
            Vec2d kingDir = kingPos.directionTo(sliderPos);

            if(directions.contains(kingDir)) {
                for (Vec2d sliderDir : sliderPiece.getSlidingVectors()) {
                    if(kingDir.scale(-1).equalDirection(sliderDir)) {
                        Set<Vec2d> kingSlides = ChessPieceSlider.getSlidingThreats(field, kingPos, kingDir, enemyColor, Set.of());
                        Set<Vec2d> sliderPieceSlides = ChessPieceSlider.getSlidingThreats(field, sliderPos, sliderDir, enemyColor, Set.of());

                        pins.addAll(kingSlides.stream()
                                .filter(v -> sliderPieceSlides.contains(v) && field.getPiece(v) != null && field.getPiece(v).isSameColor(this))
                                .collect(Collectors.toSet()));
                    }
                }
            }
        }
        return pins;
    }
}
