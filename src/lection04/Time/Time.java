package lection04.Time;

/*1. Создать класс, описывающий промежуток времени.
Сам промежуток времени должен задаваться тремя свойствами: секундами, минутами и часами.
Создать метод для получения полного количества секунд в объекте
Создать два конструктора: первый принимает общее количество секунд, второй - часы, минуты и секунды по отдельности.
Создать метод для вывода данных.
Написать программу для тестирования возможностей класса.
*/
public class Time {
    private final int MINUTES_IN_HOUR = 60;
    private final int SECONDS_IN_MINUTE = 60;
    private int seconds;
    private int minutes;
    private int hours;

    public Time(int seconds) {
        this.seconds = seconds;
    }

    public Time(int seconds, int minutes, int hours) {
        if (seconds < 0 && minutes < 0) {
            System.out.println("Неверно введенные данные");
        } else {
            this.seconds = seconds;
            this.minutes = minutes;
            this.hours = hours;
        }
    }

    public int getTimeInSeconds() {
        return seconds + SECONDS_IN_MINUTE * minutes + MINUTES_IN_HOUR * SECONDS_IN_MINUTE * hours;
    }

    public void printSeconds() {
        System.out.println("All seconds = " + this.getTimeInSeconds());
    }
}
