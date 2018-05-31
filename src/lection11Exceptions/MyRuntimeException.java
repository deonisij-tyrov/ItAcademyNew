package lection11Exceptions;

public class MyRuntimeException extends RuntimeException {
    public MyRuntimeException(String s) {
        super(s);
    }

    public MyRuntimeException(Throwable throwable) {
        super(throwable);
    }

    public MyRuntimeException() {
        super();
    }

    public MyRuntimeException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
