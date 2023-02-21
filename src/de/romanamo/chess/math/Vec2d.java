package de.romanamo.chess.math;

import de.romanamo.chess.structure.tuple.Couple;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Vec2d {

    private int x;
    private int y;

    public Vec2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vec2d(Vec2d vec2D) {
        this.x = vec2D.x;
        this.y = vec2D.y;
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
        return "Vec2d{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
