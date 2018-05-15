package lection04.ATM;

/*2. Создать класс, описывающий банкомат.
Набор купюр, находящихся в банкомате должен задаваться тремя свойствами:
количеством купюр номиналом 20, 50 и 100. Сделать методы для добавления денег в банкомат.
Сделать функцию, снимающую деньги, которая принимает сумму денег, а возвращает булевое значение - успешность выполнения операции.
При снятии денег функция должна распечатывать каким количеством купюр какого номинала выдаётся сумма.
Создать конструктор с тремя параметрами - количеством купюр каждого номинала.
*/
public class ATM {
    private static final int RATE20 = 20;
    private static final int RATE50 = 50;
    private static final int RATE100 = 100;
    private int rate20Count;
    private int rate50Count;
    private int rate100Count;

    public ATM(int rate20Count, int rate50Count, int rate100Count) {
        this.rate20Count = rate20Count;
        this.rate50Count = rate50Count;
        this.rate100Count = rate100Count;
    }

    public void addRate20(int rate20Count) {
        this.rate20Count += rate20Count;
    }

    public void addRate50(int rate50Count) {
        this.rate50Count += rate50Count;
    }

    public void addRate100(int rate100Count) {
        this.rate100Count += rate100Count;
    }

    public boolean takeOffMoney(int takeMoney) {
        int rate20 = rate20Count;
        int rate50 = rate50Count;
        int rate100 = rate100Count;
        while (takeMoney != 0) {
            if (takeMoney >= RATE100 && rate100Count > 0 && (takeMoney / 10) % 2 == 0) {
                takeMoney -= RATE100;
                rate100Count--;
            } else if (takeMoney >= RATE50 && rate50Count > 0 && ((takeMoney / 10) % 2 != 0 || takeMoney % 50 == 0)) {
                takeMoney -= RATE50;
                rate50Count--;
            } else if (takeMoney >= RATE20 && rate20Count > 0) {
                takeMoney -= RATE20;
                rate20Count--;
            } else {
                System.out.println("Ошибка выдачи");
                rate20Count = rate20;
                rate50Count = rate50;
                rate100Count = rate100;
                return false;
            }

        }
        System.out.println("Были выданы купюры номиналом\n100 : " + (rate100 - rate100Count) + ";\n 50 : " + (rate50 - rate50Count) + ";\n 20 : " + (rate20 - rate20Count) + ".");
        return true;
    }
}
