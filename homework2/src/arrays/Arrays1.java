package arrays;

import java.util.Random;
import java.util.Scanner;

public class Arrays1 {
    private static Scanner scanner;         //сканер пользовательского ввода
    private static Random random;           //генератор случайных чисел (будет использоваться для выбора типа цикла вывода на консоль, а также для перемешивания массива)
    private static int[] array;             //целочисленный массив

    public static void main(String[] arg) {
        scanner = new Scanner(System.in);
        random = new Random();

        arrayInput();

        System.out.println("\nВот массив:");
        arrayOutput(false);

        System.out.println("\nВот элементы массива на четных позициях:");
        arrayOutput(true);

        System.out.println("\nМассив после пузырьковой сортировки:");
        arrayBubbleSort();

        arrayMix();

        System.out.println("\nМассив после шейкерной сортировки:");
        arrayCocktailSort();
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

    //вывод массива на консоль (если параметр oddOnly = true - вывести только элементы на четных позициях)
    //тип цикла для вывода определяется генератором случайных чисел (o_O)
    private static void arrayOutput(boolean oddOnly) {
        //вычисление случайного числа 0..3
        int randomValue = Math.abs(random.nextInt()) % 4;

        //в зависимости от этого числа вывести массив различными циклами
        switch (randomValue) {
            //реализация вывода циклом FOR
            case 0: {
                for (int i = 0; i < array.length; i++) {
                    //если требуется выводить только элементы на четных позициях и текущая позиция четная - пропустить итерацию
                    if (oddOnly && (i % 2 != 0))
                        continue;

                    System.out.print(array[i] + " ");
                }

                System.out.println("\n* Выведено с помощью for");
                break;
            }

            //реализацич вывода циклом WHILE
            case 1: {
                int i = 0;
                while (i < array.length) {
                    if (!(oddOnly && (i % 2 != 0))) {
                        System.out.print(array[i] + " ");
                    }
                    i++;
                }

                System.out.println("\n* Выведено с помощью while");
                break;
            }

            //реализация вывода циклом DO-WHILE
            case 2: {
                int i = 0;
                do {
                    if (!(oddOnly && (i % 2 != 0))) {
                        System.out.print(array[i] + " ");
                    }
                    i++;
                } while (i < array.length);

                System.out.println("\n* Выведено с помощью do-while");
                break;
            }

            //реализация вывода циклом FOREACH
            case 3: {
                int i = 0;
                for (int item : array) {
                    if (!(oddOnly && (i % 2 != 0))) {
                        System.out.print(item + " ");
                    }
                    i++;
                }

                System.out.println("\n* Выведено с помощью foreach");
                break;
            }
        }
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

    //сортировка пузырьком
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
        arrayOutput(false);
    }

    //шейкерная сортировка
    private static void arrayCocktailSort()
    {
        int lbound = 0;
        int ubound = array.length - 1;

        while (lbound < ubound) {
            for (int i = lbound; i < ubound; i++) {
                if (array[i + 1] < array[i]) {
                    int tmp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = tmp;
                }
            }
            ubound--;

            for (int i = ubound; i < lbound; i--) {
                if (array[i - 1] > array[i]) {
                    int tmp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = tmp;
                }
            }
            lbound++;
        }
        arrayOutput(false);
    }
}