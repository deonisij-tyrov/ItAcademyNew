package lection09CollectionList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*задание 2*/
        List<Student> studentsList = createStudentsList();

        Students students = new Students(studentsList);
        System.out.println("\nвывод в обратном порядке  1:");
        students.printListReverse1();
        System.out.println("\nвывод в обратном порядке  2:");
        students.printListReverse2();
        System.out.println("\nвывод в обратном порядке  3:");
        students.printListReverse2();

        /*задание 1*/
        students.addRandomGrades();
        students.printListRating();
        students.removeBadGrades();
        System.out.println("\nизмененный рейтинг");
        students.printListRating();
        System.out.println("\nмаксимальная оценка = " + students.getMaxGrade());


    }

    public static List<Student> createStudentsList() {
        List<Student> studentsList = new ArrayList<>();
        studentsList.add(new Student("student1", 22));
        studentsList.add(new Student("student2", 23));
        studentsList.add(new Student("student3", 21));
        studentsList.add(new Student("student4", 24));
        studentsList.add(new Student("student5", 22));
        return studentsList;
    }

    public static void methodStack() {
        Stack stack = new Stack(0);
        int n = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = bufferedReader.readLine();
            stack = new Stack(s.length());
            n = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (n > 0) {
            stack.push(n % 10);
            n /= 10;
        }

        StringBuilder sb = new StringBuilder();
        int value = stack.pop();
        sb.append(value);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (value > v) {
                sb.append(v);
                value = v;
            }
        }
        if (sb.length() > 1) {
            System.out.println(sb.toString());
        }
    }
}
