package arrays;

import java.util.Random;
import java.util.Scanner;

public class Arrays1 {
    private static Scanner scanner;         //сканер пользовательского ввода
    private static Random random;           //генератор случайных чисел (будет использоваться для выбора типа цикла вывода на консоль)
    private static int[] array;             //целочисленный массив

    public static void main(String[] arg) {
        scanner = new Scanner(System.in);
        random = new Random();

        arrayInput();

        System.out.println("\nВот массив:");
        arrayOutput();

        System.out.println("\nВот элементы массива на четных позициях:");
        arrayOutputOddPosOnly();

        System.out.println("\nМассив, сортированный методом пузырька:");
        arrayBubbleSort();
    }

    //вывод массива на консоль
    //тип цикла для вывода определяется генератором случайных чисел (o_O)
    private static void arrayInput() {
        System.out.print("Введи размерность массива: ");
        int arrayLen = scanner.nextInt();

        array = new int[arrayLen];

        System.out.println("Заполни массив:");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d]:  ", i);
            array[i] = scanner.nextInt();
        }
    }

    private static void arrayOutput() {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }

    private static void arrayOutputOddPosOnly() {
        for (int i = 0; i < array.length; i += 2)
            System.out.print(array[i] + " ");
    }

    private static void arrayBubbleSort()
    {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
        arrayOutput();
    }
}