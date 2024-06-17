/*
Угнивенко Дмитрий Б763-2

Вариант В

2. Наибольшее и наименьшее число

 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] nums = new int[10];
        System.out.println("Введите элементы: ");
        Scanner scan = new Scanner(System.in);

    for(int i = 0; i < nums.length; i++){

        int value = scan.nextInt();
        nums[i] = value;

    }
    int max = nums[0];
    int min = nums[0];
    for(int i = 0; i < nums.length; i++){
        if (nums[i] > max){
            max = nums[i];
        }
        else if(nums[i] < min){
            min = nums[i];

        }
    }
    System.out.println("Максимальный элемент: " + max );
    System.out.println("Минимальный элемент: " + min );

    }
}
