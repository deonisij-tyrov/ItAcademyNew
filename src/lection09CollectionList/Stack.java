package lection09CollectionList;

/*  Задание 4. Ввести с консоли число, занести его цифры в стек. Стек – самостоятельно спроектированный класс, поддерживающий 3 операции:
    Задать размер стека.
    Внести цифру в стек.
    Извлечь цифру из стека.
    Вывести число, у которого цифры идут в обратном порядке. */

public class Stack {
    private int size;
    private int[] stackArray;
    private int top;

    public Stack(int size) {
        this.size = size;
        stackArray = new int[size];
        top = -1;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int number) {
        stackArray[++top] = number;
    }

    public int pop() {
        return stackArray[top--];
    }

}
