package lection07InnerClass;

public abstract class FourAngle extends Figure implements BasicMetodsOfQuadrilateral {
    private Point2D pointA;
    private Point2D pointB;
    private Point2D pointC;
    private Point2D pointD;
    private double sideA;
    private double sideB;
    private double sideC;
    private double sideD;


    public FourAngle(Point2D pointA, Point2D pointB, Point2D pointC, Point2D pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
        sideA = pointA.lengthOfSide(pointB);
        sideB = pointB.lengthOfSide(pointC);
        sideC = pointC.lengthOfSide(pointD);
        sideD = pointD.lengthOfSide(pointA);
    }

    public Point2D getPointA() {
        return pointA;
    }

    public Point2D getPointB() {
        return pointB;
    }

    public Point2D getPointC() {
        return pointC;
    }

    public Point2D getPointD() {
        return pointD;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public double getSideD() {
        return sideD;
    }

    @Override
    public double diagonal(Point2D fromThePoint) {
        if (fromThePoint.equals(getPointA())) {
            return fromThePoint.lengthOfSide(getPointC());
        }
        if (fromThePoint.equals(getPointB())) {
            return fromThePoint.lengthOfSide(getPointD());
        }
        if (fromThePoint.equals(getPointC())) {
            return fromThePoint.lengthOfSide(getPointA());
        }
        if (fromThePoint.equals(getPointD())) {
            return fromThePoint.lengthOfSide(getPointB());
        }
        return 0;
    }

    @Override
    public abstract double area();

    @Override
    public abstract double height(Point2D fromThePoint, double side);

    @Override
    public double perimeter() {
        return sideA + sideB + sideC + sideD;
    }
}
