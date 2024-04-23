package edu.pattern.shapes.service;

import edu.pattern.shapes.model.Point;
import edu.pattern.shapes.model.Quadrangle;

public class QuadrangleService {
    public static double calculatePerimeter(Quadrangle quadrangle) {
        double side1 = quadrangle.getTopLeft().distanceTo(quadrangle.getTopRight());
        double side2 = quadrangle.getTopRight().distanceTo(quadrangle.getBottomRight());
        double side3 = quadrangle.getBottomRight().distanceTo(quadrangle.getBottomLeft());
        double side4 = quadrangle.getBottomLeft().distanceTo(quadrangle.getTopLeft());

        return side1 + side2 + side3 + side4;
    }

    public static double distanceBetweenPoints(Point p1, Point p2) {
        double dx = p1.getX() - p2.getX();
        double dy = p1.getY() - p2.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
    public static double computeAngle(double sideA, double sideB, double sideC) {

        return Math.toDegrees(Math.acos((sideA * sideA + sideB * sideB - sideC * sideC) / (2 * sideA * sideB)));
    }
    public static boolean areTwoEdgesParallel(Point topLeft, Point topRight, Point bottomLeft, Point bottomRight) {
        if(topLeft.getX() ==  bottomLeft.getX() && topRight.getX() == bottomRight.getX() ){
            return true;
        }
        if(topLeft.getX() ==  bottomLeft.getX() || topRight.getX() == bottomRight.getX() ){
            return false;
        }

        double slope1 = (topLeft.getY() -  bottomLeft.getY()) / (topLeft.getX() -  bottomLeft.getX());
        double slope2 = (topRight.getY() -  bottomRight.getY()) / (topRight.getX() -  bottomRight.getX());

        return Math.abs(slope1 - slope2) < 1e-9;
    }
}
