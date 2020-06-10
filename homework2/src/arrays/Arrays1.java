package arrays;

import java.util.Scanner;

public class Arrays1 {
    private static Scanner scanner;
    private static int[] array;

    public static void main(String[] arg) {
        scanner = new Scanner(System.in);
        arrayInput();

        System.out.println("\nВот массив:");
        arrayOutput();

        System.out.println("\nВот элементы массива на четных позициях:");
        arrayOutputOddPosOnly();

        System.out.println("\nМассив, сортированный методом пузырька:");
        arrayBubbleSort();
    }

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