package operators;

import java.util.Objects;
import java.util.Scanner;

public class OperatorsMain3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите Ваше имя: ");
        String username = scanner.nextLine();

        System.out.println("\nРеализация IF:");
        if (Objects.equals(username, "Вася"))
            System.out.println("Привет!\nЯ тебя так долго ждал");
        if (Objects.equals(username, "Анастасия"))
            System.out.println("Я тебя так долго ждал");
        if (!Objects.equals(username, "Вася") && !Objects.equals(username, "Анастасия"))
            System.out.println("Добрый день, а вы кто?");

        System.out.println("\nРеализация IF-ELSE:");
        if (Objects.equals(username, "Вася"))
            System.out.println("Привет!\nЯ тебя так долго ждал");
        else if (Objects.equals(username, "Анастасия"))
            System.out.println("Я тебя так долго ждал");
        else
            System.out.println("Добрый день, а вы кто?");

        System.out.println("\nРеализация SWITCH:");
        switch (username)
        {
            case "Вася":
                System.out.println("Привет!\nЯ тебя так долго ждал");
                break;
            case "Анастасия":
                System.out.println("Я тебя так долго ждал");
                break;
            default:
                System.out.println("Добрый день, а вы кто?");
                break;
        }
    }
}