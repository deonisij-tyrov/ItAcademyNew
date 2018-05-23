package lection07;


public class ShapeUtils {
    public static void main(String[] args) {
        Figure square = Figure.newFigure (new PointOfCoordinates(0,0), new PointOfCoordinates(0,2), new PointOfCoordinates(2,2), new PointOfCoordinates(2,0));
        Figure triangle = Figure.newFigure (new PointOfCoordinates(0,0), new PointOfCoordinates(0,2), new PointOfCoordinates(4,0));

        System.out.println("равенство площадей : " + square.saneArea(triangle));
        System.out.println(square.area());
        System.out.println(triangle.area());

        checkFigure(square);
        checkFigure(triangle);
    }

    public static void checkFigure(Figure figure) {
        if (figure instanceof Triangle) {
            System.out.print("Треугольник");
            if (figure instanceof RectangularTriangle) {
                System.out.print(" - Прямоугольный");
            }
        }  else if (figure instanceof Parallelogram) {
            System.out.print("Параллелограмм");
            if (figure instanceof Rectangle) {
                System.out.print(" - Прямоугольник");
                if (figure instanceof Square) {
                    System.out.print(" - Квадрат");
                }
            }
        }
        System.out.println();
    }
}
