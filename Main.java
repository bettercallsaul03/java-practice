/*
Угнивенко Дмитрий Б763-2;

Вариант B.
4. Вывести на экран все числа от 1 до 100, которые делятся на 3 без остатка.

 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    for (int i = 1 ; i <= 100; i++){

    if (i % 3 == 0) {

    System.out.println(i);


            }
        }
    }
}
