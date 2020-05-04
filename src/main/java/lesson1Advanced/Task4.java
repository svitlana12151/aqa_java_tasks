package lesson1Advanced;

/*
Семантическое версионирование
Реализовать метод который принимает на вход две строки
с версиями программы ("1.0.1.2", "1.1.1.2")
и возвращает версию более ранней
Подсказка - для решения строки надо разбить на массивы
Про семантическое версионирование почитать можно здесь https://semver.org/lang/ru/
*/

public class Task4 {

    public static void main(String[] args) {
        String lovestVersion = minVersion("1.0.0.1.2", "1.0.0.2.2");
        System.out.println(lovestVersion);
    }

    public static String minVersion(String v1, String v2) {
        String lovestVersion = "v";
        char[] arr1 = v1.toCharArray(); // приводимо вхідні значення до масиву
        char[] arr2 = v2.toCharArray();

        int arr1_counter = 0; //для кожного масиву оголошуэмо каунтер
        int arr2_counter = 0;

        for (int i = 0; i < arr1.length; i++) { //створюємо цикл, що перебираэ кожне значення массивів та порівнює між саобою
            if (arr1[i] < arr2[i]) {
                arr2_counter++;
            } else if (arr1[i] > arr2[i]) {
                arr1_counter++;
            }
            if (arr1_counter < arr2_counter) {
                lovestVersion = v1;
            } else
                lovestVersion = v2;
        }
        return lovestVersion;
    }
}