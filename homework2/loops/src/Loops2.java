import java.util.Scanner;

public class Loops2 {
    public static void main(String[] args) {
        if (args.length == 1) {
            String arg = args[0];
            if (tryParseInt(arg)) {
                int n = Integer.parseInt(arg);
                System.out.printf("%d! = %d", n, getFactorial(n));
            }
            else
                System.out.println("Для работы этой программы нужен целочисленный параметр командной строки!");
        }
        else
            System.out.println("Для работы этой программы нужен параметр командной строки!");
    }

    private static boolean tryParseInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    private static int getFactorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}