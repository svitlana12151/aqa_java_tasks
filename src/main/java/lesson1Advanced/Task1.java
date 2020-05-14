package main.java.lesson1Advanced;

public class Task1 {
    /* Минимум n чисел
    Написать функцию, которая вычисляет минимум из массива чисел.
    */
    public static void main(String[] args) {
        int a[] = {2, 4, 6}; // якщо я не ініацілізую тут масив - то в мене System.out.println(min([2, 4, 6])) підсвідчуєтсья як помилка
        System.out.println(min(a));
        //System.out.println(min([2,4,6]));
        //System.out.println(min([2,4,6,1,90,2,0]));
    }

    public static int min(int[] a) {
        int a_min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < a_min) {
                a_min = a[i];
            }
        }
        return a_min;
    }
}