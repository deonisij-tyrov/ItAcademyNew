package lection07InnerClass;

public class RectangularTriangle extends Triangle {
    public RectangularTriangle(Point2D pointA, Point2D pointB, Point2D pointC) {
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
