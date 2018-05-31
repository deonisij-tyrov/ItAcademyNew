package lection11Exceptions;

public class MyException extends Exception {

    public MyException() {
    }

    public MyException(Throwable throwable) {
        super(throwable);
    }

    public MyException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public MyException(String s) {
        super(s);
    }
}
