package lection07;

public class Square extends Rectangle {
    public Square(PointOfCoordinates pointA, PointOfCoordinates pointB, PointOfCoordinates pointC, PointOfCoordinates pointD) {
        super(pointA, pointB, pointC, pointD);
    }

    @Override
    public double area() {
        return Math.pow(getSideA(), 2);
    }

    @Override
    public double height(PointOfCoordinates fromThePoint, double side) {
        return side;
    }

    @Override
    public String toString() {
        return this.getClass().toString() + " " + getPointA() + " " + getPointB() + " " + getPointC() + " " + getPointD() + " - квадрат";
    }
}
