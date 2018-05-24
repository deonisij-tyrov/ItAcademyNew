package lection07;

public class RectangularTriangle extends Triangle {
    public RectangularTriangle(PointOfCoordinates pointA, PointOfCoordinates pointB, PointOfCoordinates pointC) {
        super(pointA, pointB, pointC);
    }

    @Override
    public double area() {
        return getSideA() * getSideC() / 2;
    }

    @Override
    public String toString() {
        return this.getClass().toString() + " " + getSideA() + " " + getPointB() + " " + getSideC() + " - прямоугольный треугольник";
    }
}
