package loops;

public class Loops3 {
    public static void main(String[] args) {
        if (args.length == 1) {
            String arg = args[0];
            if (tryParseInt(arg)) {
                int n = Integer.parseInt(arg);
                System.out.printf("Сумма цифр числа %d равна %d", n, getDigitsSum(n));
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

    private static int getDigitsSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum *= n % 10;
            n /= 10;
        }
        return sum;
    }
}