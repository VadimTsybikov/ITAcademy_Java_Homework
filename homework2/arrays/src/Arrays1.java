import java.util.Scanner;

public class Arrays1 {
    private static Scanner scanner;
    private static int[] array;

    public static void main(String[] arg) {
        scanner = new Scanner(System.in);
        ArrayInput();
        ArrayOutput();
        ArrayOutputOddPosOnly();
        ArrayBubbleSort();
    }

    private static void ArrayInput() {
        System.out.print("Введи размерность массива: ");
        int arrayLen = scanner.nextInt();

        array = new int[arrayLen];

        System.out.println("Заполни массив:");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d]:  ", i);
            array[i] = scanner.nextInt();
        }
    }

    private static void ArrayOutput() {
        System.out.println("\nВот массив:");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }

    private static void ArrayOutputOddPosOnly() {
        System.out.println("\nВот элементы массива на четных позициях:");
        for (int i = 0; i < array.length; i += 2)
            System.out.print(array[i] + " ");
    }

    private static void ArrayBubbleSort()
    {
        //копирование оригинального массива во временный буфер, чтобы не рушить оригинальный порядок элементов
        int[] a = new int[array.length];
        for (int i = 0; i < a.length; i++)
            a[i] = array[i];

        //сортировка методом пузырька
        for (int i = 0; i < a.length - 1; i++)
            for (int j = i; j < a.length; j++) {
                if (a[j - 1] < a[j]) {
                    int tmp = a[j - 1];
                    a[j - 1] = a[i];
                    a[i] = tmp;
                }
            }

        System.out.println("\nМассив, сортированный методом пузырька:");
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }
}