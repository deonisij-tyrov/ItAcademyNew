package lection12Strings;


public class Main {
    public static void main(String[] args) {
//        task1();
//        task2();
//        System.out.println(task3(":)", ":) task3 :)"));
//        System.out.println(task4("фамилия", "ИМЯ", "Отчество"));
//        System.out.println(task5("asd asda   asdqa     "));
//        System.out.println(task6("aaddss"));
    }

    /*Написать два цикла, выполняющих многократное сложение строк, один с помощью оператора сложения и String, 
    второй с помощью StringBuilder и метода append. Сравнить скорость их выполнения.*/
    public static void task1() {
        System.out.println("add String: " + addString());
        System.out.println("add StringBuilder: " + addStringBuilder());
        System.out.println("add addConcat: " + addConcat());

    }

    private static long addString() {
        long time = 0;
        for (int i = 0; i < 100; i++) {
            String s = "s";
            long startTime = System.nanoTime();
            for (int j = 0; j < 10000; j++) {
                s += "s";
            }
            long endTime = System.nanoTime();
            time += endTime - startTime;
        }
        return time / 100;
    }

    private static long addStringBuilder() {
        long time = 0;
        for (int i = 0; i < 100; i++) {
            StringBuilder s = new StringBuilder();
            long startTime = System.nanoTime();
            for (int j = 0; j < 10000; j++) {
                s.append("s");
            }
            long endTime = System.nanoTime();
            time += endTime - startTime;
        }
        return time / 100;
    }

    private static long addConcat() {
        long time = 0;
        for (int i = 0; i < 100; i++) {
            String s = "s";
            long startTime = System.nanoTime();
            for (int j = 0; j < 10000; j++) {
                s = s.concat("s");
            }
            long endTime = System.nanoTime();
            time += endTime - startTime;
        }
        return time / 100;
    }

    /*Заменить все грустные смайлы :( в строке на весёлые :)*/
    public static void task2() {
        String s = "настроение :(.";
        s = s.concat(s);
        s = s.concat(s);
        s = s.concat(s);
        System.out.println(s);
        s = s.replaceAll(":\\(", ":)");
        System.out.println(s);
    }

    /*Написать функцию, принимающую 2 параметра: строку и слово - и возвращающую true, если строка начинается и заканчивается этим словом.*/
    public static boolean task3(String word, String s) {
        if (s.startsWith(word) && s.endsWith(word)) {
            return true;
        }else {
            return false;
        }
    }

    /*Написать функцию, принимающую в качестве параметров имя, фамилию и отчество и возвращающую инициалы
    в формате "Ф.И.О". Учесть, что входные параметры могут быть в любом регистре, а результирующая строка должна быть в верхнем.*/
    public static String task4(String sName, String fName, String mName) {
        StringBuilder builder = new StringBuilder();
        builder.append(sName.toUpperCase().charAt(0) + ".");
        builder.append(fName.toUpperCase().charAt(0) + ".");
        builder.append(mName.toUpperCase().charAt(0) + ".");
        return builder.toString();
    }

    /*Подсчитать количество слов в тексте. Учесть, что слова могут разделяться несколькими пробелами.*/
    public static int task5(String s) {
        String[] strings = s.split(" ");
        int i = 0;
        for (String st : strings) {
            if(!st.equals("")) {
                i++;
            }
        }
        return i;
    }

    /*Написать функцию, заменяющую несколько последовательных одинаковых символов в строке одним.
    Пример: aaabbcdeef ->abcdef*/
    public static String task6(String s) {
        return s.replaceAll("([a-z])\\1+", "$1");
    }
}
