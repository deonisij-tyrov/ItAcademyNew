package lection07InnerClass;

public class Parallelogram extends FourAngle {
    public Parallelogram(Point2D pointA, Point2D pointB, Point2D pointC, Point2D pointD) {
        super(pointA, pointB, pointC, pointD);
    }

    @Override
    public double area() {
        double height = height(getPointA(), getSideA());
        return Math.rint(height * getSideA());
    }

    @Override
    public double height(Point2D fromThePoint, double side) {
        /*полупериметр*/
        double perimeter = perimeter() / 2;
        double dioganal = diagonal(fromThePoint);
        return Math.sqrt(perimeter * (perimeter - getSideA()) * (perimeter - getSideB()) * perimeter - dioganal) * 2 / side;
    }

    @Override
    public String toString() {
        return this.getClass().toString() + " " + getPointA() + " " + getPointB() + " " + getPointC() + " " + getPointD() + " - параллелограмм";
    }
}
