package lection07;

public class Rectangle extends Quadrilateral implements BasicMetodsOfFigure {
    public Rectangle(PointOfCoordinates pointA, PointOfCoordinates pointB, PointOfCoordinates pointC, PointOfCoordinates pointD) {
        super(pointA, pointB, pointC, pointD);
    }

    @Override
    public double area() {
        return getSideA() * getSideB();
    }

    @Override
    public double height(PointOfCoordinates fromThePoint, double side) {
        if (getSideA() == side) {
            return getSideB();
        } else {
            return getSideA();
        }
    }
}
