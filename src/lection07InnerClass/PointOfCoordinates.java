package lection07InnerClass;

public class PointOfCoordinates {
    private int x;
    private int y;

    public PointOfCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double lengthOfSide (PointOfCoordinates point) {
        return Math.hypot(point.getX() - this.x, point.getY() - this.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PointOfCoordinates)) return false;

        PointOfCoordinates that = (PointOfCoordinates) o;

        if (getX() != that.getX()) return false;
        return getY() == that.getY();
    }

    @Override
    public int hashCode() {
        int result = getX();
        result = 31 * result + getY();
        return result;
    }
}
