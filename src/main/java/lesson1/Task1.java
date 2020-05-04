package lesson1;

public class Task1 {
    /* Минимум трех чисел
    Написать функцию, которая вычисляет минимум из трёх чисел.
    */
    public static void main(String[] args) {
        System.out.println(min(5,2,3));
    }

    public static int min(int a, int b, int c) {
        int min = 0; // IDEA просить ініціалізувати змінну. Чому не можна просто оголосити?
        if (a < b && a < c)
            min = a;
        else if (b < a && b < c)
            min = b;
        else if (c < a && c < b)
            min = c;
        return min;
    }
}
