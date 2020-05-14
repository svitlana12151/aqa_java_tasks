package main.java.lesson1;

public class Task1 {
    /* Минимум трех чисел
    Написать функцию, которая вычисляет минимум из трёх чисел.
    */
    public static void main(String[] args) {
        minOfThreeValues(5, 2, 3);
    }

    public static int minOfThreeValues(int a, int b, int c) {
        /*a = 5;
        b = 2;
        c = 3;*/
        int min = 0;
        if (a < b && a < c)
            min = a;
        else if (b < a && b < c)
            min = b;
        else if (c < a && c < b)
            min = c;
        return min;
    }
}
