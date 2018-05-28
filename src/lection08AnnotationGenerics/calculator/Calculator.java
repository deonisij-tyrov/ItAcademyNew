package lection08AnnotationGenerics.calculator;

import lection08AnnotationGenerics.annotation.Transaction;

public class Calculator<T extends Number> {

    public Number amount(T t1, T t2) {
        if (realNmber(t1)) {
            return (t1.doubleValue() + t2.doubleValue());
        } else {
            return t1.longValue() + t2.longValue();
        }
    }

    @Transaction
    public Number composition(T t1, T t2) {
        if (realNmber(t1)) {
            return (t1.doubleValue() * t2.doubleValue());
        } else {
            return t1.longValue() * t2.longValue();
        }
    }

    public Number difference(T t1, T t2) {
        if (realNmber(t1)) {
            return (t1.doubleValue() - t2.doubleValue());
        } else {
            return t1.longValue() - t2.longValue();
        }
    }

    @Transaction
    public Number division(T t1, T t2) {
        if (realNmber(t1)) {
            return (t1.doubleValue() / t2.doubleValue());
        } else {
            return t1.longValue() / t2.longValue();
        }
    }

    private boolean realNmber(T t) {
        if (t instanceof Double || t instanceof Float) {
            return true;
        }
        return false;
    }
}
