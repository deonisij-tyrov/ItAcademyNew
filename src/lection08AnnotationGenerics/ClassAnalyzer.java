package lection08AnnotationGenerics;

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
        System.out.println("Имя суперкласса" + c.getSuperclass().getName());

        Class[] interfaces = c.getInterfaces();
        if (interfaces.length > 0) {
            System.out.println("Интерфейсы: ");
            for (Class clazz : interfaces) {
                System.out.print(clazz + " ");
            }
        }
        getAnnotationInformation(c.getAnnotations());
    }

    private static void getFieldInformation(Class c) {
        Field[] fields = c.getFields();
        if (fields.length > 0) {
            System.out.println("Доступные поля: ");
            for (Field f : fields) {
                System.out.print(f.getType() + " " + f.getName() + ", ");
                getAnnotationInformation(f.getAnnotations());
            }
        }

        fields = c.getDeclaredFields();
        if (fields.length > 0) {
            System.out.println("Закрытые поля: ");
            for (Field f : fields) {
                System.out.print(f.getType() + " " + f.getName() + ", ");
                getAnnotationInformation(f.getAnnotations());
            }
        }
    }

    private static void getMethodInformation(Class c) {
        Method[] methods = c.getMethods();
        System.out.println("Доступные методы: ");
        for (Method method : methods) {
            if (!method.getName().equals("equals") && !method.getName().equals("clone") && !method.getName().equals("finalize") && !method.getName().equals("getClass") &&
                    !method.getName().equals("hashCode") && !method.getName().equals("notify") && !method.getName().equals("notifyAll") && !method.getName().equals("toString") &&
                    !method.getName().equals("wait")) {
                System.out.println("Имя метода: " + method.getName());
                System.out.println("Тип возвращаемого значения: " + method.getReturnType().getName());

                Class[] paramTypes = method.getParameterTypes();
                System.out.print("Типы параметров: ");
                for (Class paramType : paramTypes) {
                    System.out.print(" " + paramType.getName());
                }
            }
            getAnnotationInformation(method.getAnnotations());
        }

        methods = c.getDeclaredMethods();
        System.out.println("Скрытые методы: ");
        for (Method method : methods) {
            System.out.println("Имя скрытого метода: " + method.getName());
            System.out.println("Тип возвращаемого значения: " + method.getReturnType().getName());

            Class[] paramTypes = method.getParameterTypes();
            System.out.print("Типы параметров: ");
            for (Class paramType : paramTypes) {
                System.out.print(" " + paramType.getName());
            }
            getAnnotationInformation(method.getAnnotations());
        }
    }

    private static void getConstructorInformation(Class c) {
        Constructor[] constructors = c.getConstructors();
        if (constructors.length > 0) {
            System.out.println("Конструктор(ы) открытый(е):");
            printConstructor(constructors);
        }
        Constructor[] declaredConstructors = c.getDeclaredConstructors();
        if (declaredConstructors.length > 0) {
            System.out.println("Конструктор(ы) закрытый(е):");
            printConstructor(declaredConstructors);
        }
    }

    private static void printConstructor(Constructor[] constructors) {
        for (Constructor constructor : constructors) {
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class paramType : paramTypes) {
                System.out.print(paramType.getName() + " ");
            }
            System.out.println();
        }
    }

    private static void getAnnotationInformation(Annotation[] annotations) {
        if (annotations.length > 0) {
            System.out.println("\nАннотация:");
            for (Annotation a : annotations) {
                System.out.println(a);
            }
        }
        System.out.println();
    }
}
