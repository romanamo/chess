package de.romanamo.chess.math;

import de.romanamo.chess.structure.tuple.Couple;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Class to describe a 2 dimensional Vector
 * in a cartesian Integer grid coordinate System
 */
public class Vec2d {

    private final int x;
    private final int y;

    public Vec2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vec2d(Vec2d vec2D) {
        this.x = vec2D.x;
        this.y = vec2D.y;
    }

    /**
     * Returns a new {@link Vec2d Vector}
     * by performing Vector addition
     *
     * @param v Vector to add
     * @return the Sum of both Vectors
     */
    public Vec2d add(Vec2d v) {
        return new Vec2d(x + v.getX(), y + v.getY());
    }

    public Vec2d scale(int s) {
        return new Vec2d(s * x, s * y);
    }

    public Vec2d rotate(double angle) {
        int rotatedX = (int) Math.rint(x * Math.cos(angle) - y * Math.sin(angle));
        int rotatedY = (int) Math.rint(x * Math.sin(angle) + y * Math.cos(angle));

        return new Vec2d(rotatedX, rotatedY);
    }

    public Vec2d mirror(boolean onXAxis, boolean onYAxis) {
        int mirroredX = onXAxis ? x * -1 : x;
        int mirroredY = onYAxis ? y * -1 : y;

        return new Vec2d(mirroredX, mirroredY);
    }

    public Vec2d normalize() {
        double radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

        int normalizedX = (int) Math.rint(x / radius);
        int normalizedY = (int) Math.rint(y / radius);

        return new Vec2d(normalizedX, normalizedY);
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vec2d vec2d = (Vec2d) o;

        if (x != vec2d.x) return false;
        return y == vec2d.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public static Couple<Vec2d, Vec2d> getCornerVectors(Collection<Vec2d> vecList) {
        List<Integer> xValues = vecList.stream().map(Vec2d::getX).toList();
        List<Integer> yValues = vecList.stream().map(Vec2d::getY).toList();

        Vec2d cornerVec1 = new Vec2d(Collections.min(xValues), Collections.min(yValues));
        Vec2d cornerVec2 = new Vec2d(Collections.max(xValues), Collections.max(yValues));

        return new Couple<>(cornerVec1, cornerVec2);
    }

    @Override
    public String toString() {
        //return ChessNotation.translateVector(this);
        return "(" + x + ", " + y + ")";
    }
}
