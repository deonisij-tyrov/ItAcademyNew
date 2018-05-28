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
        getAnnotationInformation(c);
    }

    public static void analyze(Object o) {
        getClassInformation(o.getClass());
        getMethodInformation(o.getClass());
        getConstructorInformation(o.getClass());
        getAnnotationInformation(o.getClass());
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

        Field[] fields = c.getFields();
        if (fields.length > 0) {
            System.out.println("Доступные поля: ");
            for (Field f : fields) {
                System.out.print(f.getType() + " " + f.getName() + ", ");
            }
        }

        fields = c.getDeclaredFields();
        if (fields.length > 0) {
            System.out.println("Закрытые поля: ");
            for (Field f : fields) {
                System.out.print(f.getType() + " " + f.getName() + ", ");
            }
        }
    }

    private static void getMethodInformation(Class c) {
        Method[] methods = c.getMethods();
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
                System.out.println();
            }
        }
    }

    private static void getConstructorInformation(Class c) {
        Constructor[] constructors = c.getConstructors();
        if (constructors.length > 0) {
            System.out.println("Конструктор(ы) открытый(е):");
            for (Constructor constructor : constructors) {
                Class[] paramTypes = constructor.getParameterTypes();
                for (Class paramType : paramTypes) {
                    System.out.print(paramType.getName() + " ");
                }
                System.out.println();
            }
        }
        Constructor[] declaredConstructors = c.getDeclaredConstructors();
        if (declaredConstructors.length > 0) {
            System.out.println("Конструктор(ы) закрытый(е):");
            for (Constructor constructor : declaredConstructors) {
                Class[] paramTypes = constructor.getParameterTypes();
                for (Class paramType : paramTypes) {
                    System.out.print(paramType.getName() + " ");
                }
                System.out.println();
            }
        }
    }

    private static void getAnnotationInformation(Class c) {
        Annotation[] annotations = c.getAnnotations();
        if (annotations.length > 0) {
            System.out.println("Аннотации для класса открытые:");
            for (Annotation a : annotations) {
                getClassInformation(a.getClass());
                getMethodInformation(a.getClass());
                getConstructorInformation(a.getClass());
            }
        }
    }
}
