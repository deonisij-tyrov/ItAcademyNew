package lection11Exceptions;

public class Main {
    public static void main (String[] args) {
        try {
            Integer integer = new Integer(null);
            integer.longValue();
        }catch (NumberFormatException e) {
            System.out.println(e.toString());
        }

    }
}
