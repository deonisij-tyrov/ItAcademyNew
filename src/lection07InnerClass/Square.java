package lection07InnerClass;

public class Square extends Rectangle {
    public Square(Point2D pointA, Point2D pointB, Point2D pointC, Point2D pointD) {
        super(pointA, pointB, pointC, pointD);
    }

    @Override
    public double area() {
        return Math.pow(getSideA(), 2);
    }

    @Override
    public double height(Point2D fromThePoint, double side) {
        return side;
    }

    @Override
    public String toString() {
        return this.getClass().toString() + " " + getPointA() + " " + getPointB() + " " + getPointC() + " " + getPointD() + " - квадрат";
    }
}
