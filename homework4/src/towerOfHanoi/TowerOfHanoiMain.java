package towerOfHanoi;

import java.util.Scanner;

public class TowerOfHanoiMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameLauncher launcher = new GameLauncher();

        boolean repeat = false;
        do {
            launcher.Start();
            System.out.println("Повторить игру (y/n)?");
            repeat = scanner.nextLine().equals("y");
        } while (repeat);
    }
}