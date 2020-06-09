import java.util.Scanner;

public class Arrays1 {
    private static Scanner scanner;
    private static int[] array;

    public static void main(String arg) {
        scanner = new Scanner(System.in);
        ArrayInput();
        ArrayOutput();
        ArrayOutputOddPosOnly();
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
        System.out.println("Вот массив:");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }

    private static void ArrayOutputOddPosOnly() {
        System.out.println("Вот элементы массива на четных позициях:");
        for (int i = 0; i < array.length; i += 2)
            System.out.print(array[i] + " ");
    }

    private static void ArrayBubbleSort()
    {
        System.out.println("Массив, сортированный методом пузырька:");
        for (int i = 0; i < array.length; i += 2)
            System.out.print(array[i] + " ");
    }
}