package lection07InnerClass;

public abstract class Figure {
    public static Figure newFigure(PointOfCoordinates pointA, PointOfCoordinates pointB, PointOfCoordinates pointC, PointOfCoordinates pointD) {
        double sideA = pointA.lengthOfSide(pointB);
        double sideB = pointB.lengthOfSide(pointC);
        double sideC = pointC.lengthOfSide(pointD);
        double sideD = pointD.lengthOfSide(pointA);

        if (sideA == sideC && sideB == sideD) {                                                                                                                 //параллелограмм ?
            if (hasrightAngle(sideA, sideB, pointB.lengthOfSide(pointD))) {                                                                                    //прямоугольник ?
                if (sideA == sideB) {                                                                                                                           //квадрат ?
                    return new Square(pointA, pointB, pointC, pointD);
                } else {
                    return new Rectangle(pointA, pointB, pointC, pointD);
                }
            } else {
                if (sideA == sideB) {
                    return new Rhombus(pointA, pointB, pointC, pointD);
                } else {
                    return new Parallelogram(pointA, pointB, pointC, pointD);
                }
            }
        }
        System.out.println("Фигура не определена");
        return null;
    }

    public static Figure newFigure(PointOfCoordinates pointA, PointOfCoordinates pointB, PointOfCoordinates pointC) {
        double sideA = pointA.lengthOfSide(pointB);
        double sideB = pointB.lengthOfSide(pointC);
        double sideC = pointC.lengthOfSide(pointA);

        if (sideA + sideB < sideC || sideB + sideC < sideA || sideC + sideA < sideB) {
            System.out.println("Неверные данные");
        } else if (hasrightAngle(sideA, sideB, sideC)) {                                    //прямоугольный ?
            return new RectangularTriangle(pointA, pointB, pointC);
        } else {
            return new Triangle(pointA, pointB, pointC);
        }

        System.out.println("Фигура не определена");
        return null;
    }

    private static boolean hasrightAngle(double sideA, double sideB, double sideC) {
        return sideA == Math.sqrt(Math.pow(sideB, 2) + Math.pow(sideC, 2)) ||
                sideB == Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideC, 2)) ||
                sideC == Math.sqrt(Math.pow(sideB, 2) + Math.pow(sideA, 2));
    }

    public abstract double area();

    public boolean saneArea(Figure figure) {
        return this.area() == figure.area();
    }
}
