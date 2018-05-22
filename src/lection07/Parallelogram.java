package lection07;

public class Parallelogram extends Quadrilateral implements BasicMetodsOfFigure {
    public Parallelogram(PointOfCoordinates pointA, PointOfCoordinates pointB, PointOfCoordinates pointC, PointOfCoordinates pointD) {
        super(pointA, pointB, pointC, pointD);
    }

    @Override
    public double areaOfTheFigure() {
        return 0;
    }

    @Override
    public double heightOfFigure(PointOfCoordinates fromThePoint, double side) {
        return 0;
    }
}
