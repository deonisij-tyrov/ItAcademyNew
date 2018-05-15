package lection04;

import lection04.ATM.ATM;
import lection04.Time.Time;
import lection04.homeTask.Point;
import lection04.homeTask.Rectangle;

public class MainForLection04 {
    public static void main (String[] args) {
//        Time time1 = new Time(380);
//        time1.printSeconds();
//        Time time2 = new Time(55, 1, 1);
//        time2.printSeconds();

        ATM atm = new ATM(4,4,3);
        atm.takeOffMoney(160);
//
//        Point point1 = new Point(4,4);
//        Point point2 = new Point(6,2);
//
//        Rectangle rectangle = new Rectangle(point1, point2);
//        System.out.println("Площадь" + rectangle.getArea());
//        System.out.println("Диагональ" + rectangle.getDiagonal());
    }
}
