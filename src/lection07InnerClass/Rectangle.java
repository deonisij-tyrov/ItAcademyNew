package lection07InnerClass;

public class Rectangle extends Parallelogram {
    public Rectangle(Point2D pointA, Point2D pointB, Point2D pointC, Point2D pointD) {
        super(pointA, pointB, pointC, pointD);
    }

    @Override
    public double area() {
        return getSideA() * getSideB();
    }

    @Override
    public double height(Point2D fromThePoint, double side) {
        if (getSideA() == side) {
            return getSideB();
        } else {
            return getSideA();
        }
    }

    @Override
    public String toString() {
        return this.getClass().toString() + " " + getPointA() + " " + getPointB() + " " + getPointC() + " " + getPointD() + " - прямоугольник";
    }
}
