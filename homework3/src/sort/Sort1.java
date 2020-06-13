package sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Sort1 {
    private static Scanner scanner;         //сканер пользовательского ввода
    private static Random random;           //генератор случайных чисел (для перемешивания массива)
    private static int[] array;             //целочисленный массив

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        random = new Random();

        arrayInput();

        System.out.println("\nВот массив:");
        arrayOutput(array);

        System.out.println("\nМассив после сортировки выбором:");
        arrayOutput(arraySelectionSort(array));

        arrayMix();

        System.out.println("\nМассив после сортировки с использованием вставок:");
        arrayOutput(arrayInclusionSort(array));

        arrayMix();

        System.out.println("\nМассив после сортировки слиянием:");
        arrayOutput(arrayMergeSort(array));
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
    private static void arrayOutput(int[] _array) {
        for (int i = 0; i < _array.length; i++) {
            System.out.print(_array[i] + " ");
        }
        System.out.println();
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
        arrayOutput(array);
    }

    //сортировка выбором
    private static int[] arraySelectionSort(int[] _array) {
        for (int i = _array.length - 1; i > 0; i--) {
            int max = _array[0];
            int maxPos = 0;

            for (int j = 1; j <= i; j++) {
                if (max < _array[j]) {
                    max = _array[j];
                    maxPos = j;
                }
            }

            int tmp = _array[i];
            _array[i] = _array[maxPos];
            _array[maxPos] = tmp;
        }

        return _array;
    }

    //сортировка с использованием вставок
    private static int[] arrayInclusionSort(int[] _array) {
        for (int i = 1; i < _array.length; i++) {
            int val = _array[i];
            int valPos = i;

            while ((valPos > 0) && (_array[valPos - 1] > val)) {
                _array[valPos] = _array[valPos - 1];
                valPos--;
            }

            _array[valPos] = val;
        }

        return _array;
    }

    //сортировка слиянием
    private static int[] arrayMergeSort(int[] _array) {
        int part1Length = _array.length / 2;
        int part2Length = _array.length - part1Length;

        int[] part1 = Arrays.copyOfRange(_array, 0, part1Length);
        if (part1.length > 1)
            part1 = arrayMergeSort(part1);

        int[] part2 = Arrays.copyOfRange(_array, part1Length, _array.length);
        if (part2.length > 1)
            part2 = arrayMergeSort(part2);

        int part1Top = 0;
        int part2Top = 0;
        int arrayTop = 0;
        while ((part1Top < part1.length) && (part2Top < part2.length)) {
            if (part1[part1Top] < part2[part2Top]) {
                _array[arrayTop++] = part1[part1Top++];
            }
            else {
                _array[arrayTop++] = part2[part2Top++];
            }
        }

        while (part1Top < part1.length) {
            _array[arrayTop++] = part1[part1Top++];
        }

        while (part2Top < part2.length) {
            _array[arrayTop++] = part2[part2Top++];
        }

        return _array;
    }
}