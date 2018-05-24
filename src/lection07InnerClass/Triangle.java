package lection07InnerClass;

public class Triangle extends Figure implements BasicMetodsOfFigure {
    PointOfCoordinates pointA;
    PointOfCoordinates pointB;
    PointOfCoordinates pointC;
    double sideA;
    double sideB;
    double sideC;

    public Triangle(PointOfCoordinates pointA, PointOfCoordinates pointB, PointOfCoordinates pointC) {
        double sideA = pointA.lengthOfSide(pointB);
        double sideB = pointB.lengthOfSide(pointC);
        double sideC = pointC.lengthOfSide(pointA);

        if (sideA + sideB < sideC || sideB + sideC < sideA || sideC + sideA < sideB) {
            System.out.println("Неверные данные");
        } else {
            this.pointA = pointA;
            this.pointB = pointB;
            this.pointC = pointC;
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }
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

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    @Override
    public double perimeterOfTheFigure() {
        return sideA + sideB + sideC;
    }

    @Override
    public double area() {
        return height(getPointA(),sideB) * sideB / 2;
    }

    @Override
    public double height(PointOfCoordinates fromThePoint, double side) {
        /*полупериметр*/
        double perimeter = perimeterOfTheFigure() / 2;
        return Math.sqrt(perimeter * (perimeter - getSideA()) * (perimeter - getSideB()) * perimeter - getSideC()) * 2 / side;
    }
}
