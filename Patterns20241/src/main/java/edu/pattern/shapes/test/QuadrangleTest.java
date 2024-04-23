package edu.pattern.shapes.test;

import edu.pattern.shapes.model.Point;
import edu.pattern.shapes.model.Quadrangle;
import edu.pattern.shapes.model.QuadrangleState;
import edu.pattern.shapes.service.QuadrangleService;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuadrangleTest {
    @Test
    public void testTrapezoid() {
        Point topLeft = new Point(0, 0);
        Point topRight = new Point(4, 0);
        Point bottomLeft = new Point(1, 4);
        Point bottomRight = new Point(3, 4);

        assertEquals(QuadrangleState.TRAPEZOID, QuadrangleState.detect(topLeft, topRight, bottomLeft, bottomRight));
    }
    @Test
    public void testInvalidInput() {
        Point topLeft = null;
        Point topRight = new Point(1, 1);
        Point bottomLeft = new Point(2, 2);
        Point bottomRight = new Point(3, 3);

        assertThrows(IllegalArgumentException.class, () -> QuadrangleState.detect(topLeft, topRight, bottomLeft, bottomRight));
    }
    @Test
    public void testUNKNOWN() {
        Point topLeft = new Point(3, 4);
        Point topRight = new Point(10, 4);
        Point bottomLeft = new Point(0, 0);
        Point bottomRight = new Point(7, 0);

        assertEquals(QuadrangleState.UNKNOWN, QuadrangleState.detect(topLeft, topRight, bottomLeft, bottomRight));
    }
    @Test
    public void testRHOMBUS() {
        Point topLeft = new Point(0, 0);
        Point topRight = new Point(2, 0);
        Point bottomLeft = new Point(0, 2);
        Point bottomRight = new Point(2, 2);

        assertEquals(QuadrangleState.RHOMBUS, QuadrangleState.detect(topLeft, topRight, bottomLeft, bottomRight));
    }

    @Test
    public void testRECTANGLE() {
        Point topLeft = new Point(1, 3);
        Point topRight = new Point(6, 3);
        Point bottomLeft = new Point(1, 0);
        Point bottomRight = new Point(6, 0);

        assertEquals(QuadrangleState.RECTANGLE, QuadrangleState.detect(topLeft, topRight, bottomLeft, bottomRight));
    }
    @Test
    public void testCalculatePerimeter() {
        Quadrangle quadrangle = new Quadrangle(
                new Point(0, 0),
                new Point(4, 0),
                new Point(4, 3),
                new Point(0, 3)
        );
        assertEquals(18.0, QuadrangleService.calculatePerimeter(quadrangle),0.0001);
    }
    @Test
    public void testDistanceBetweenPoints() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        assertEquals(5.0, QuadrangleService.distanceBetweenPoints(p1, p2), 0.0001);
    }
    @Test
    public void testComputeAngle() {
        double sideA = 3;
        double sideB = 4;
        double sideC = 5;
        assertEquals(90.0, QuadrangleService.computeAngle(sideA, sideB, sideC), 0.0001);
    }

    @Test
    public void testAreTwoEdgesParallel() {
        Point topLeft = new Point(0, 0);
        Point topRight = new Point(4, 0);
        Point bottomLeft = new Point(0, 4);
        Point bottomRight = new Point(4, 4);
        assertTrue(QuadrangleService.areTwoEdgesParallel(topLeft, topRight, bottomLeft, bottomRight));
    }
}
