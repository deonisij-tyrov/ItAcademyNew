package lection07InnerClass;

public class Rectangle extends Parallelogram {
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

    @Override
    public String toString() {
        return this.getClass().toString() + " " + getPointA() + " " + getPointB() + " " + getPointC() + " " + getPointD() + " - прямоугольник";
    }
}
