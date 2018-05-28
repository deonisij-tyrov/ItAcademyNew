package lection08AnnotationGenerics.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TransactionAnalyzer {
    public static void analyzerTransaction(Object o) {
        for (Method method : o.getClass().getMethods()) {
            if (method.isAnnotationPresent(Transaction.class)) {
                System.out.println("Transaction is started");
                try {
                    System.out.println(method.invoke(o, new Integer[]{new Integer(1), new Integer(2)}));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                System.out.println("Transaction is ended");
            }
        }
    }
}
