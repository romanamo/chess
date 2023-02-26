package de.romanamo.chess.math;

import de.romanamo.chess.structure.tuple.Couple;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Class to describe a {@link Vec2d 2-dimensional Vector}
 * <p>
 * The vector-components only consist of integers of type {@code int}.
 * Every operation onto a vector that would yield a vector with non-integer components,
 * rounds each component towards the nearest integer value.
 * </p>
 * <p>
 * Operations concerning the transformation of a vector,
 * always return a newly created vector-object.
 * </p>
 */
public class Vec2d {

    private final int x;
    private final int y;

    /**
     * Constructor for a {@link Vec2d Vector}
     *
     * @param x x-component
     * @param y y-component
     */
    public Vec2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor for a {@link Vec2d Vector}.
     * Creates a Vector by taking component values of the given Vector.
     *
     * @param vec2D Vector to copy
     */
    public Vec2d(Vec2d vec2D) {
        this.x = vec2D.x;
        this.y = vec2D.y;
    }

    /**
     * Adds another {@link Vec2d Vector} onto a Vector.
     *
     * @param v Vector to add
     * @return the sum of both Vectors
     */
    public Vec2d add(Vec2d v) {
        return new Vec2d(x + v.getX(), y + v.getY());
    }

    /**
     * Scales a {@link Vec2d Vector} by a given scalar.
     *
     * @param s Scalar, to shrink or expand the Vector
     * @return the scaled Vector
     */
    public Vec2d scale(int s) {
        return new Vec2d(s * x, s * y);
    }

    /**
     * Rotates a {@link Vec2d Vector} by the given angle by given radian.
     * Rounds the components to the nearest integer.
     *
     * @param angle to rotate
     * @return the rotated Vector
     */
    public Vec2d rotate(double angle) {
        int rotatedX = (int) Math.rint(x * Math.cos(angle) - y * Math.sin(angle));
        int rotatedY = (int) Math.rint(x * Math.sin(angle) + y * Math.cos(angle));

        return new Vec2d(rotatedX, rotatedY);
    }

    /**
     * Mirrors a {@link Vec2d Vector} on specified Axis.
     *
     * @param onXAxis if a Reflection on the X-Axis is performed
     * @param onYAxis if a Reflection on the Y-Axis is performed
     * @return the mirrored Vector
     */
    public Vec2d mirror(boolean onXAxis, boolean onYAxis) {
        int mirroredX = onXAxis ? x * -1 : x;
        int mirroredY = onYAxis ? y * -1 : y;

        return new Vec2d(mirroredX, mirroredY);
    }

    /**
     * Normalizes a {@link Vec2d Vector} to unit length 1,
     * using euclidean Distance. Rounds the components to the nearest Integer.
     * <p>
     * Because the Null-vector {@code (0,0)} cannot be normalized,
     * we will return the Null-Vector for consistency.
     *
     * @return the normalized Vector
     */
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
