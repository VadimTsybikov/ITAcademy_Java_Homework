package towerOfHanoi;

import java.util.Scanner;

public class TowerOfHanoiMain {
    private static Scanner scanner;
    private static GameLauncher launcher;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        launcher = new GameLauncher();

        printMain();
    }

    public static void printMain() {
        while (true) {
            System.out.println("ХАНОЙСКАЯ БАШНЯ:");
            System.out.println("1. Начать игру");
            System.out.println("2. Демо");
            System.out.println("3. Выход");

            int selectedCase = scanner.nextInt();
            switch (selectedCase) {
                case 1: {
                    launcher.start();
                    break;
                }
                case 2: {
                    launcher.autoplay();
                    break;
                }
                case 3: {
                    return;
                }
            }
        }
    }
}