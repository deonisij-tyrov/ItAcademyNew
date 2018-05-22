package lection07;

public class Rectangle extends Quadrilateral implements BasicMetodsOfFigure {
    public Rectangle(PointOfCoordinates pointA, PointOfCoordinates pointB, PointOfCoordinates pointC, PointOfCoordinates pointD) {
        super(pointA, pointB, pointC, pointD);
    }

    @Override
    public double areaOfTheFigure() {
        return getSideA() * getSideB();
    }

    @Override
    public double heightOfFigure(PointOfCoordinates fromThePoint, double side) {
        if (getSideA() == side) {
            return sideB;
        } else {
            return sideA;
        }
    }
}
