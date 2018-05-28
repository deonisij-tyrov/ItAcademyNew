package lection07InnerClass;

public class Rhombus extends Parallelogram{
    public Rhombus(Point2D pointA, Point2D pointB, Point2D pointC, Point2D pointD) {
        super(pointA, pointB, pointC, pointD);
    }

    @Override
    public String toString() {
        return this.getClass().toString() + " " + getPointA() + " " + getPointB() + " " + getPointC() + " " + getPointD() + " - ромб";
    }
}
