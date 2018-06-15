package lection11Exceptions;

import lection09CollectionList.Student;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Main {
    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        task1();
//        task2();
//        task3();
//        task4();

//        task6();
//        task7();
    }

    /*Объявите переменную со значением null. Вызовите метод у этой переменной.
    Отловите возникшее исключение.*/
    static void task1() {
        Student student = null;
        try {
            student.getName();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    /*Написать код, который создаст, а затем отловит ArrayIndexOutOfBoundsException.*/
    static void task2() {
        int[] i = new int[10];
        try {
            int n = i[11];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    /*Создать собственный класс-исключение - наследник класса Exception.
    Создать метод, выбрасывающий это исключение.
    Вызвать этот метод и отловить исключение. Вывести stacktrace в консоль.*/
    static void task3() {
        try {
            throw new MyException("MyExeption");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /*Повторить предыдущее упражнение, но наследуя свой класс от класса RuntimeException.
    Добавить вконструктор своего класса возможность указания сообщения.*/
    static void task4() {
        try {
            throw new MyRuntimeException("MyRuntimeException(((");
        } catch (MyRuntimeException e) {
            e.printStackTrace();
        }
    }

    /*Бросить одно из существующих в JDK исключений, отловить его и выбросить своё собственное,указав в качестве причины отловленное.*/
    static void task5() {
        try {
            throw new IOException();
//            throw new NullPointerException();
        } catch (RuntimeException e) {
            try {
                throw new MyRuntimeException(e);
            } catch (MyRuntimeException e1) {
                e1.printStackTrace();
            }
        } catch (Exception e) {
            try {
                throw new MyException(e);
            } catch (MyException e1) {
                e1.printStackTrace();
            }
        }
    }

    /*Создать метод случайным образом выбрасывающий одно из 3-х видов исключений.
    Вызвать этот метод в блоке try-catch, отлавливающем любое из 3-х.*/
    static void task6() {
        try {
            switch ((int) (Math.random() * 3)) {
                case 0:
                    throw new MyException();
                case 1:
                    throw new MyRuntimeException();
                case 2:
                    throw new Exception();
            }
        } catch (MyRuntimeException e) {
            logger.error(e);
        } catch (MyException e) {
            logger.error(e);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    /*Написать метод, который в 50% случаев бросает исключение.
    Вызвать этот метод в конструкции try-catch-finally. Протестировать работу блока finally.*/
    static void task7() {
        try {
            if ((Math.random() * 10) > 4) {
                throw new MyException("исключение");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            logger.info("это тут есть всегда");
        }


    }
}
