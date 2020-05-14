package main.java.lesson1;

/* Мое имя
Вывести на экран свое имя 5 строк по 10 раз (через пробел).
System.out.println, System.out.print можно использовать только по одному разу
для этого нужно воспользоваться циклом for
*/

public class Task2 {

    public static void main(String[] args) {
       printMatrixOfNames();
      }

    public static String[][] printMatrixOfNames() {
        String s = "Svitlana ";
        String arrOfNames [][] = new String[10][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(s);
            }
            System.out.println();

        }
        return arrOfNames;
    }
}

