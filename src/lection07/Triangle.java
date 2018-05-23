package lection07;

public class Triangle extends Figure implements BasicMetodsOfFigure {
    private PointOfCoordinates pointA;
    private PointOfCoordinates pointB;
    private PointOfCoordinates pointC;
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(PointOfCoordinates pointA, PointOfCoordinates pointB, PointOfCoordinates pointC) {
            this.pointA = pointA;
            this.pointB = pointB;
            this.pointC = pointC;
            this.sideA = pointA.lengthOfSide(pointB);
            this.sideB = pointB.lengthOfSide(pointC);
            this.sideC = pointC.lengthOfSide(pointA);
    }

    public PointOfCoordinates getPointA() {
        return pointA;
    }

    public PointOfCoordinates getPointB() {
        return pointB;
    }

    public PointOfCoordinates getPointC() {
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
    public double perimeterOfTheFigure() {
        return sideA + sideB + sideC;
    }

    @Override
    public double area() {
        return Math.rint(height(getPointA(),sideB) * sideB / 2);
    }

    @Override
    public double height(PointOfCoordinates fromThePoint, double side) {
        /*полупериметр*/
        double perimeter = perimeterOfTheFigure() / 2;
        return Math.sqrt(perimeter * (perimeter - getSideA()) * (perimeter - getSideB()) * (perimeter - getSideC())) * 2 / side;
    }

    @Override
    public String toString() {
        return this.getClass().toString() + " " + pointA + " " + pointB + " " + pointC + " - треугольник";
    }
}
