package sort;

import java.util.Random;
import java.util.Scanner;

public class Sort1 {
    private static Scanner scanner;         //сканер пользовательского ввода
    private static Random random;           //генератор случайных чисел (для перемешивания массива)
    private static int[] array;             //целочисленный массив

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        arrayInput();

        System.out.println("\nВот массив:");
        arrayOutput(false);

        System.out.println("\nВот элементы массива на четных позициях:");
        arrayOutput(true);

        System.out.println("\nМассив после сортировки выбором:");
        arraySelectionSort();

        arrayMix();

        System.out.println("\nМассив после сортировки с использованием вставок:");
        arrayInclusionSort();
    }

    //ввод с консоли
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

    //вывод массива на консоль
    private static void arrayOutput(boolean oddOnly) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    //сортировка выбором
    private static void arraySelectionSort() {
        for (int i = array.length - 1; i > 0; i--) {
            int max = array[0];
            int maxPos = 0;

            for (int j = 1; j <= i; j++) {
                if (max < array[j]) {
                    max = array[j];
                    maxPos = j;
                }
            }

            int tmp = array[i];
            array[i] = array[maxPos];
            array[maxPos] = tmp;
        }
        arrayOutput(false);
    }

    //перемешивание элементов массива (для последующей демонстрации сортировки)
    private static void arrayMix() {
        for (int i = 0; i < array.length; i++) {
            int destIndex = Math.abs(random.nextInt() + i) % array.length;
            int tmp = array[i];
            array[i] = array[destIndex];
            array[destIndex] = tmp;
        }

        System.out.println("\nМассив перемешан:");
        arrayOutput(false);
    }

    //сортировка с использованием вставок
    private static void arrayInclusionSort() {
        for (int i = 1; i < array.length; i++) {
            int val = array[i];
            int valPos = i;

            while ((valPos > 0) && (array[valPos] > array[valPos - 1])) {
                array[valPos] = array[valPos - 1];
                valPos--;
            }

            array[valPos] = val;
        }
        arrayOutput(false);
    }
}