package sort;

import sort.core.Sort;

import java.util.*;

public class SortMain {
    private static Scanner scanner;         //сканер пользовательского ввода
    private static Random random;           //генератор случайных чисел (для перемешивания массива)

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        random = new Random();
        int[] array = arrayInput();

        System.out.println("\nВот массив:");
        arrayOutput(array);

        Sort.arraySelectionSort(array);
        System.out.println("\nМассив после сортировки выбором:");
        arrayOutput(array);

        arrayMix(array);

        Sort.arrayInclusionSort(array);
        System.out.println("\nМассив после сортировки с использованием вставок:");
        arrayOutput(array);

        arrayMix(array);

        Sort.arrayMergeSort(array);
        System.out.println("\nМассив после сортировки слиянием:");
        arrayOutput(array);

        arrayMix(array);

        Sort.arrayQuickSort(array, 0, array.length - 1);
        System.out.println("\nМассив после сортировки c помощью разделения:");
        arrayOutput(array);
    }

    //ввод с консоли
    private static int[] arrayInput() {
        System.out.print("Введи размерность массива: ");
        int arrayLen = scanner.nextInt();

        int[] array = new int[arrayLen];

        System.out.println("Заполни массив:");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d]:  ", i);
            array[i] = scanner.nextInt();
        }

        return array;
    }

    //вывод массива на консоль
    private static void arrayOutput(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    //перемешивание элементов массива (для последующей демонстрации сортировки)
    private static void arrayMix(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //вычисляем случайную позицию в оставшейся части массива
            int destIndex = Math.abs(random.nextInt() + i) % array.length;

            //обмениваем значение этой случайной позиции с текущей
            int tmp = array[i];
            array[i] = array[destIndex];
            array[destIndex] = tmp;
        }

        System.out.println("\nМассив перемешан:");
        arrayOutput(array);
    }
}