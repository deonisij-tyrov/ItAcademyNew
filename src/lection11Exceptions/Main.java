package lection11Exceptions;

import lection09CollectionList.Student;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        task7();
    }

    static void task1() {
        Student student = null;
        try {
            student.getName();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    static void task2() {
        int[] i = new int[10];
        try {
            int n = i[11];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    static void task3() {
        try {
            throw new MyException();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    static void task4() {
        try {
            throw new MyRuntimeException("MyException(((");
        } catch (MyRuntimeException e) {
            e.printStackTrace();
        }
    }

    static void task5() {
        try {
            throw new IOException();
//            throw new NullPointerException();
        } catch (Exception e) {
            try {
                throw new MyException(e);
            } catch (MyException e1) {
                System.out.println(e1.toString());
            }
        }
    }

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
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void task7() {


        try {
            if ((Math.random() * 10) > 4) {
                throw new MyException("исключение");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("это тут есть всегда");
        }
    }
}
