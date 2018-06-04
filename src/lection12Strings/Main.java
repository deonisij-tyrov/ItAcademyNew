package lection12Strings;


public class Main {
    public static void main(String[] args) {
        System.out.println("_______________");
        task1();
        System.out.println("_______________");
        task2("настроение :(.");
        System.out.println("_______________");
        System.out.println(task3(":)", ":) task3 :)"));
        System.out.println("_______________");
        System.out.println(task4("фамилия", "ИМЯ", "Отчество"));
        System.out.println("_______________");
        System.out.println(task5(" asd asda        asdqa     "));
        System.out.println("_______________");
        System.out.println(task6("121111asdadsaddddzzzzzzzzzzzяяяяяяяяяяя"));
    }

    /*Написать два цикла, выполняющих многократное сложение строк, один с помощью оператора сложения и String, 
    второй с помощью StringBuilder и метода append. Сравнить скорость их выполнения.*/
    public static void task1() {
        for (int i = 0; i < 10; i++) {
            System.out.println("add String: " + addString());
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("add StringBuilder: " + addStringBuilder());
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("add addConcat: " + addConcat());
        }
    }

    private static long addString() {
        String s = "s";
        long startTime = System.nanoTime();
        for (int j = 0; j < 10000; j++) {
            s += "s";
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long addStringBuilder() {
        StringBuilder s = new StringBuilder();
        long startTime = System.nanoTime();
        for (int j = 0; j < 10000; j++) {
            s.append("s");
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long addConcat() {
        String s = "s";
        long startTime = System.nanoTime();
        for (int j = 0; j < 10000; j++) {
            s = s.concat("s");
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /*Заменить все грустные смайлы :( в строке на весёлые :)*/
    public static void task2(String s) {
        if (s == null) {
            System.out.println("err");
        } else {
            System.out.println(s);
            s = s.replaceAll(":\\(", ":)");
            System.out.println(s);
        }
    }

    /*Написать функцию, принимающую 2 параметра: строку и слово - и возвращающую true, если строка начинается и заканчивается этим словом.*/
    public static boolean task3(String word, String s) {
        if (word != null && s != null && s.startsWith(word) && s.endsWith(word)) {
            return true;
        } else {
            return false;
        }
    }

    /*Написать функцию, принимающую в качестве параметров имя, фамилию и отчество и возвращающую инициалы
    в формате "Ф.И.О". Учесть, что входные параметры могут быть в любом регистре, а результирующая строка должна быть в верхнем.*/
    public static String task4(String sName, String fName, String mName) {
        StringBuilder builder = new StringBuilder();
        if (sName != null) {
            builder.append(Character.toUpperCase(sName.charAt(0)) + ".");
        }
        if (fName != null) {
            builder.append(Character.toUpperCase(fName.charAt(0)) + ".");
        }
        if (mName != null) {
            builder.append(Character.toUpperCase(mName.charAt(0)) + ".");
        }
        return builder.toString();
    }

    /*Подсчитать количество слов в тексте. Учесть, что слова могут разделяться несколькими пробелами.*/
    public static int task5(String s) {
        if (s == null) {
            return 0;
        }
        if (s.startsWith(" ") || s.endsWith(" ")) {
            s = s.trim();
        }
        String[] strings = s.split(" +");
        return strings.length;
    }

    /*Написать функцию, заменяющую несколько последовательных одинаковых символов в строке одним.
    Пример: aaabbcdeef ->abcdef*/
    public static String task6(String s) {
        if (s == null) {
            return null;
        }
        return s.replaceAll("([\\wа-я])\\1+", "$1");
    }
}
