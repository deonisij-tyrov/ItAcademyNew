package lection07InnerClass;


public class ShapeUtils {
    public static void main(String[] args) {
        Figure square = Figure.newFigure(new Point2D(0, 0), new Point2D(0, 2), new Point2D(2, 2), new Point2D(2, 0));
        Figure triangle = Figure.newFigure(new Point2D(0, 0), new Point2D(0, 2), new Point2D(4, 0));

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
        } else if (figure instanceof Parallelogram) {
            System.out.print("Параллелограмм");
            if (figure instanceof Rectangle) {
                System.out.print(" - Прямоугольник");
                if (figure instanceof Square) {
                    System.out.print(" - Квадрат");
                }
            } else {
                System.out.print(" - Ромб");
            }
        }
        System.out.println();
    }
}
