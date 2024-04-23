package edu.pattern.shapes.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static edu.pattern.shapes.service.QuadrangleService.computeAngle;
import static edu.pattern.shapes.service.QuadrangleService.distanceBetweenPoints;
import static edu.pattern.shapes.service.QuadrangleService.areTwoEdgesParallel;


public enum QuadrangleState {
    INVALID, UNKNOWN, SQUARE, RECTANGLE, RHOMBUS, TRAPEZOID;

    public static QuadrangleState detect(Point topLeft, Point topRight, Point bottomLeft, Point bottomRight) {
        if (topLeft == null || topRight == null || bottomLeft == null || bottomRight == null) {
            throw new IllegalArgumentException("All points must be provided");
        }

        double side1 = distanceBetweenPoints(bottomLeft, topLeft);
        double side2 = distanceBetweenPoints(topLeft, topRight);
        double side3 = distanceBetweenPoints(topRight, bottomRight);
        double side4 = distanceBetweenPoints(bottomRight, bottomLeft);

        double angle1 = computeAngle(side1, side2, distanceBetweenPoints(bottomLeft, topRight));
        double angle2 = computeAngle(side2, side3, distanceBetweenPoints(topLeft, bottomRight));
        double angle3 = computeAngle(side3, side4, distanceBetweenPoints(topRight, bottomLeft));
        double angle4 = computeAngle(side4, side1, distanceBetweenPoints(bottomRight, topLeft));

        Set<Double> uniqueSides = new HashSet<>(Arrays.asList(side1, side2, side3, side4));
        boolean allSidesEqual = uniqueSides.size() == 1;
        boolean allAnglesEqual = angle1 == angle2 && angle2 == angle3 && angle3 == angle4;
        boolean hasRightAngles = angle1 == 90 && angle2 == 90 && angle3 == 90 && angle4 == 90;

        if (allSidesEqual) {
            if (allAnglesEqual && hasRightAngles) {
                return SQUARE;
            }
            else {
                return RHOMBUS;
            }
        }
        else {
            if (allAnglesEqual && hasRightAngles) {
                return RECTANGLE;
            }
            else {
                if( (areTwoEdgesParallel(topLeft, topRight, bottomLeft, bottomRight) && !areTwoEdgesParallel(bottomLeft, topLeft, bottomRight, topRight)) ||
                        (areTwoEdgesParallel(bottomLeft, topLeft, bottomRight, topRight) && !areTwoEdgesParallel(topLeft, topRight, bottomLeft, bottomRight))) {
                    return TRAPEZOID;
                }
            }
        }

        return UNKNOWN;
    }
}
