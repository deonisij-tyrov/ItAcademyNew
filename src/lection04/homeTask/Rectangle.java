package lection04.homeTask;

public class Rectangle {
    private Point leftUpper;
    private Point rightBottom;

    public Rectangle(Point leftUpper, Point rightBottom) {
        this.leftUpper = leftUpper;
        this.rightBottom = rightBottom;
    }

    public double getDiagonal() {
        return leftUpper.distance(rightBottom);
    }

    public double getArea() {
        return Math.abs(leftUpper.getX() - rightBottom.getX()) * Math.abs(leftUpper.getY() - rightBottom.getY());
    }
}
