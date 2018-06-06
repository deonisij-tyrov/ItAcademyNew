package lection13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        System.out.println("______________________________________\nзадача 1");
        String s1 = "asdsda_1232131@adasd.com";
        System.out.printf("Строка %s - emal: %s\n", s1, isEmail(s1));

        System.out.println("______________________________________\nзадача 2");
        String s2 = "В Java используются целочисленные литералы, например: 35 — целое деся-\n" +
                "тичное число, 071 — восьмеричное число, 0x51b,0X54213abab — шестнадцатеричное чи-\n" +
                "сло, 0b1010 — двоичное число (введено в Java 7). Целочисленные литералы";
        findHexadecimal(s2);

        System.out.println("______________________________________\nзадача 3");
        String s3 = "<div class=\"header\"> \n" +
                "   <div class=\"subTitle\">\n" +
                "    <span class=\"packageLabelInType\">Package</span>&nbsp;\n" +
                "    <a href=\"../../../org/jsoup/nodes/package-summary.html\">org.jsoup.nodes</a>\n" +
                "   </div> \n" +
                "   <h2 title=\"Class Element\" class=\"title\">Class Element</h2> \n" +
                "  </div>";
        System.out.println(replaceTeg(s3));

        System.out.println("______________________________________\nзадача 4");
        findPhoneNumber("ghfghfhjg +375295077120 +375291111111");

        System.out.println("______________________________________\nзадача 5");
        System.out.println("Mask - " + isMaskIPv4("255.0.0.0"));
        System.out.println("IPv4 - " + isIPv4("254.0.0.0"));
    }

    /*1. Написать программу, проверяющую, является ли введённая строка адресом электронного почтового ящика.
    В названии почтового ящика разрешить использование только букв, цифр и нижних подчёркиваний, при этом оно должно начинаться с буквы.
    Возможные домены верхнего уровня: .org .com */
    private static boolean isEmail(String s) {
        if (s == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[a-zA-Z]+\\w*@[a-zA-Z]*\\.(com|org)$");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    /*2. Написать программу, выполняющую поиск в строке шестнадцатеричных чисел, записанных по правилам Java,
    с помощью регулярных выражений и выводящую их на страницу.*/
    private static void findHexadecimal(String s) {
        if (s == null) {
            return;
        }
        Pattern pattern = Pattern.compile("0[xX][0-9a-fA-F]+");
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    /*3. Написать программу, выполняющую поиск в строке всех тегов абзацев, в т.ч. тех, у которых есть параметры, например <p id ="p1">,
    и замену их на простые теги абзацев <p>.//для всех тегов с параметрами*/
    private static String replaceTeg(String s) {
        if (s == null) {
            try {
                throw new NullPointerException("html text not find");
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
            return null;
        }
        return s.replaceAll("<([a-z0-9]+) +[^>]+>", "<$1>");
    }

    /*4. Написать программу, выполняющую поиск в строке мобильных телефонных номеров в формате +375XXYYYYYYY
    и заменяющую каждый телефон на тот же, но в формате +375 (XX) YYY-YY-YY
    X - код оператора
    Y - номер телефона*/
    private static void findPhoneNumber(String s) {
        if (s == null) {
            return;
        }
        System.out.println(s.replaceAll("(\\+375)(\\d{2})(\\d{3})(\\d{2})(\\d{2})", "$1 ($2) $3-$4-$5"));
    }

    /*5.Написать метод, который проверяет, является ли строка адресом IPv4.*/
    private static boolean isMaskIPv4(String s) {
        final int BINARY_BASE = 2;
        if (s == null) {
            return false;
        }
        String[] strings = s.split("\\.");
        if (strings.length < 4) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            try {
                int n = Integer.parseInt(strings[i]);
                if (n < 0 || n > 255) {
                    return false;
                }
                sb.append(Integer.toString(n, BINARY_BASE));
            } catch (NumberFormatException e) {
                System.out.println(e.toString());
                return false;
            }
        }
        Pattern pattern = Pattern.compile("(^1+(?=0)0*$)|(^0(?<=0)0*$)|(^1+(?=1)1*$)");
        Matcher matcher = pattern.matcher(sb.toString());
        return matcher.matches();
    }

    private static boolean isIPv4(String s) {
        if (s == null) {
            return false;
        }
        String[] strings = s.split("\\.");
        if (strings.length < 4) {
            return false;
        }

        Matcher matcher = Pattern.compile("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$").matcher(s);
        if (matcher.matches() == false) {
            return false;
        }
        for (String string : strings) {
            try {
                int n = Integer.parseInt(string);
                if (n > 254 || n < 0) {
                    return false;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.toString());
                return false;
            }
        }
        return true;
    }
}
