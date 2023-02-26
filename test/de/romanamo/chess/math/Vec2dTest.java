package de.romanamo.chess.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Vec2dTest {


    @Test
    void rotateTest() {
        Vec2d v = new Vec2d(1, 2);
        Vec2d rotatedV = new Vec2d(2, -1);

        assertEquals(rotatedV, v.rotate(Math.PI * (3 / 2.0)));
        assertEquals(rotatedV, v.rotate(Math.PI * -1.0 * (1 / 2.0)));
    }

    @Test
    void addTest() {
        Vec2d v1 = new Vec2d(123, 452);
        Vec2d v2 = new Vec2d(101, 334);

        assertEquals(new Vec2d(224, 786), v1.add(v2));
        assertEquals(new Vec2d(224, 786), v2.add(v1));
    }

    @Test
    void scaleTest() {
        Vec2d v1 = new Vec2d(1, 0);
        Vec2d v2 = new Vec2d(0, 1);

        assertEquals(new Vec2d(2,0), v1.scale(2));
        assertEquals(new Vec2d(0,2), v2.scale(2));
    }

    @Test
    void mirror() {
        Vec2d v1 = new Vec2d(2, 1);

        assertEquals(new Vec2d(-2, -1), v1.mirror(true, true));
    }

    @Test
    void normalizeTest() {
        Vec2d v1 = new Vec2d(2, 0);
        Vec2d v2 = new Vec2d(0, 2);

        assertEquals(new Vec2d(1, 0), v1.normalize());
        assertEquals(new Vec2d(0, 1), v2.normalize());

    }

    @Test
    void normalizeNullVectorTest() {
        Vec2d v1 = new Vec2d(0, 0);

        assertEquals(new Vec2d(0, 0), v1.normalize());
    }
}