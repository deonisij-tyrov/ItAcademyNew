package lection08AnnotationGenerics.analyzer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassAnalyzer {
    public static void analyze(Class c) {
        getClassInformation(c);
        getMethodInformation(c);
        getConstructorInformation(c);
        getFieldInformation(c);
    }

    public static void analyze(Object o) {
        getClassInformation(o.getClass());
        getMethodInformation(o.getClass());
        getConstructorInformation(o.getClass());
        getFieldInformation(o.getClass());
    }

    private static void getClassInformation(Class c) {
        System.out.println("Имя класса: " + c.getName());
        getAnnotationInformation(c.getAnnotations());
        Class[] interfaces = c.getInterfaces();
        if (interfaces.length > 0) {
            System.out.println("Интерфейсы: ");
            for (Class clazz : interfaces) {
                System.out.print(clazz + " ");
            }
        }
        System.out.println();
    }

    private static void getFieldInformation(Class c) {
        Field[] fields = c.getDeclaredFields();
        if (fields.length > 0) {
            System.out.println("Поля: ");
            for (Field f : fields) {
                System.out.println("\t" + f.getType() + " " + f.getName() + ", ");
                getAnnotationInformation(f.getAnnotations());
            }
        }
        System.out.println();
    }

    private static void getMethodInformation(Class c) {
        Method[] methods = c.getDeclaredMethods();
        System.out.println("Доступные методы: ");
        for (Method method : methods) {
            System.out.println("\t" + method.toString());
            getAnnotationInformation(method.getAnnotations());
        }
        System.out.println();
    }

    private static void getConstructorInformation(Class c) {
        Constructor[] constructors = c.getDeclaredConstructors();
        if (constructors.length > 0) {
            System.out.println("Конструктор(ы) :");
            for (Constructor constructor : constructors) {
                System.out.println("\t" + constructor.toString());
            }
        }
    }

    private static void getAnnotationInformation(Annotation[] annotations) {
        if (annotations.length > 0) {
            System.out.println("\tАннотация:");
            for (Annotation a : annotations) {
                System.out.println("\t\t" + a);
            }
        }
    }
}
