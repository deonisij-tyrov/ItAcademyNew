package lection07InnerClass;

public class Triangle extends Figure implements BasicMetodsOfFigure {
    private Point2D pointA;
    private Point2D pointB;
    private Point2D pointC;
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(Point2D pointA, Point2D pointB, Point2D pointC) {
            this.pointA = pointA;
            this.pointB = pointB;
            this.pointC = pointC;
            this.sideA = pointA.lengthOfSide(pointB);
            this.sideB = pointB.lengthOfSide(pointC);
            this.sideC = pointC.lengthOfSide(pointA);
    }

    public Point2D getPointA() {
        return pointA;
    }

    public Point2D getPointB() {
        return pointB;
    }

    public Point2D getPointC() {
        return pointC;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    @Override
    public double perimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double area() {
        return Math.rint(height(getPointA(),sideB) * sideB / 2);
    }

    @Override
    public double height(Point2D fromThePoint, double side) {
        /*полупериметр*/
        double perimeter = perimeter() / 2;
        return Math.sqrt(perimeter * (perimeter - getSideA()) * (perimeter - getSideB()) * (perimeter - getSideC())) * 2 / side;
    }

    @Override
    public String toString() {
        return this.getClass().toString() + " " + pointA + " " + pointB + " " + pointC + " - треугольник";
    }
}
