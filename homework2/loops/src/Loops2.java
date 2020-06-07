import java.util.Scanner;

public class Loops2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введи число: ");
        int n = scanner.nextInt();

        System.out.printf("%d! = %d", n, getFactorial(n));
    }

    public static int getFactorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}