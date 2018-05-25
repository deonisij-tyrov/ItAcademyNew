package lection07InnerClass;

public abstract class Quadrilateral extends Figure implements BasicMetodsOfQuadrilateral {
    private PointOfCoordinates pointA;
    private PointOfCoordinates pointB;
    private PointOfCoordinates pointC;
    private PointOfCoordinates pointD;
    private double sideA;
    private double sideB;
    private double sideC;
    private double sideD;


    public Quadrilateral(PointOfCoordinates pointA, PointOfCoordinates pointB, PointOfCoordinates pointC, PointOfCoordinates pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
        sideA = pointA.lengthOfSide(pointB);
        sideB = pointB.lengthOfSide(pointC);
        sideC = pointC.lengthOfSide(pointD);
        sideD = pointD.lengthOfSide(pointA);
    }

    public PointOfCoordinates getPointA() {
        return pointA;
    }

    public PointOfCoordinates getPointB() {
        return pointB;
    }

    public PointOfCoordinates getPointC() {
        return pointC;
    }

    public PointOfCoordinates getPointD() {
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
    public double diagonal(PointOfCoordinates fromThePoint) {
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
    public abstract double height(PointOfCoordinates fromThePoint, double side);

    @Override
    public double perimeterOfTheFigure() {
        return sideA + sideB + sideC + sideD;
    }
}
