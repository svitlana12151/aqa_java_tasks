package lesson1;

/* Мое имя
Вывести на экран свое имя 5 строк по 10 раз (через пробел).
System.out.println, System.out.print можно использовать только по одному разу
для этого нужно воспользоваться циклом do () while
*/

public class Task4 {

    public static void main(String[] args) {
        String s = "Svitlana ";
        int row = 0;
        int col = 0;
        do {
            System.out.println();
            row++;
            do {
                System.out.print(s);
                col++;
            }
            while (col < 10);
            col = 0;
        }
        while (row < 5);
    }
        /*System.out.println(
                s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " "
                        + s);
        System.out.println(
                s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " "
                        + s);
        System.out.println(
                s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " "
                        + s);
        System.out.println(
                s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " "
                        + s);
        System.out.println(
                s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " "
                        + s);
    }*/
}