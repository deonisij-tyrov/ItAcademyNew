package lection13;

import com.sun.javafx.binding.StringFormatter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        findPhoneNumber("ghfghfhjg +375295077120");
    }

    private static void findPhoneNumber(String s) {
        Pattern pattern = Pattern.compile("(\\+375)(\\d{2})(\\d{3})(\\d{2})(\\d{2})");
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            s = matcher.replaceAll(String.format("%s (%s) %s-%s-%s",matcher.group(1),
                    matcher.group(2), matcher.group(3), matcher.group(4), matcher.group(5)));
            System.out.println(s);
        }
    }
}
