package lection07;

public class Square extends Rectangle {
    public Square(PointOfCoordinates pointA, PointOfCoordinates pointB, PointOfCoordinates pointC, PointOfCoordinates pointD) {
        super(pointA, pointB, pointC, pointD);
    }

    @Override
    public double areaOfTheFigure() {
        return Math.pow(this.sideA, 2);
    }

    @Override
    public double heightOfFigure(PointOfCoordinates fromThePoint, double side) {
        return side;
    }
}
