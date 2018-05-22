package lection07;

public class Parallelogram extends Quadrilateral {
    public Parallelogram(PointOfCoordinates pointA, PointOfCoordinates pointB, PointOfCoordinates pointC, PointOfCoordinates pointD) {
        super(pointA, pointB, pointC, pointD);
    }

    @Override
    public double area() {
        double height = height(getPointA(), getSideA());
        return height * getSideA();
    }

    @Override
    public double height(PointOfCoordinates fromThePoint, double side) {
        /*полупериметр*/
        double perimeter = perimeterOfTheFigure() / 2;
        double dioganal = diagonal(fromThePoint);
        return Math.sqrt(perimeter * (perimeter - getSideA()) * (perimeter - getSideB()) * perimeter - dioganal) * 2 / side;
    }
}
