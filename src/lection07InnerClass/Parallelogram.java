package lection07InnerClass;

public class Parallelogram extends Quadrilateral {
    public Parallelogram(PointOfCoordinates pointA, PointOfCoordinates pointB, PointOfCoordinates pointC, PointOfCoordinates pointD) {
        super(pointA, pointB, pointC, pointD);
    }

    @Override
    public double area() {
        double height = height(getPointA(), getSideA());
        return Math.rint(height * getSideA());
    }

    @Override
    public double height(PointOfCoordinates fromThePoint, double side) {
        /*полупериметр*/
        double perimeter = perimeterOfTheFigure() / 2;
        double dioganal = diagonal(fromThePoint);
        return Math.sqrt(perimeter * (perimeter - getSideA()) * (perimeter - getSideB()) * perimeter - dioganal) * 2 / side;
    }

    @Override
    public String toString() {
        return this.getClass().toString() + " " + getPointA() + " " + getPointB() + " " + getPointC() + " " + getPointD() + " - параллелограмм";
    }
}