package towerOfHanoi;

import java.util.Scanner;

public class GameLauncher {
    private Scanner scanner;
    private byte[][] playField;             //игровое поле
    private byte[] pinTopIndeces;           //индексы верхних колец на штырях
    private final byte pinsCnt = 3;         //количество штырей
    private byte ringsCnt;                  //количество колец

    public GameLauncher() {
        scanner = new Scanner(System.in);
    }

    //запуск игрового процесса
    public void Start() {
        initPlayField();

        while (!isDone()) {
            printPlayField();
            askMovement();
        }
        
        printPlayField();
        System.out.println("Вы выиграли!");
    }

    //инициализация игрового поля
    private void initPlayField() {
        //повторять запрос числа колец до тех пор, пока не будут введены адекватные значения
        while (true) {
            System.out.print("Укажите число колец (3-8): ");

            ringsCnt = scanner.nextByte();
            if (!(ringsCnt >= 3 && ringsCnt <= 8)) {
                System.out.println("Введено некорректное число!");
                continue;
            }

            playField = new byte[ringsCnt][pinsCnt];

            //сброс загруженности штырей
            pinTopIndeces = new byte[pinsCnt];
            for (int i = 0; i < pinsCnt; i++)
                pinTopIndeces[i] = -1;

            //нанизывание на 1-й штырь нужного числа колец
            byte rowsCnt = (byte)playField.length;
            byte maxRingWeight = rowsCnt;               //вес самого большого кольца равен количеству колец
            for (int i = 0; i < rowsCnt; i++) {
                playField[i][0] = maxRingWeight--;
                pinTopIndeces[0]++;
            }
            break;
        }
    }

    //вывод состояния штырей (колец на них)
    private void printPlayField() {
        for (int i = playField.length - 1; i >= 0; i--) {
            for (byte ring : playField[i]) {
                System.out.print((ring > 0 ? ring : "*") + " ");
            }
            System.out.println();
        }
    }

    //запрос направления перемещения кольца, валидация введенных данных
    private void askMovement() {
        //повторять запрос вектора перемещения до тех пор, пока не будут введены адекватные значения
        while (true) {
            System.out.printf("Введите два числа от 1 до %d через пробел) (с какого штыря переместить кольцо на какой): ", pinsCnt);
            byte fromPin = scanner.nextByte();
            byte toPin = scanner.nextByte();

            //проверка адекватности введенных номеров
            if (fromPin < 1 || fromPin > pinsCnt || toPin < 1 || toPin > pinsCnt) {
                System.out.println("Введены некорректные данные!");
                continue;
            }
            else {
                //преобразование номера штыря в индекс массива
                fromPin--;
                toPin--;
            }

            byte movingRing = getTopRing(fromPin);          //перемещаемое кольцо
            byte lastRingAtDest = getTopRing(toPin);        //верхнее кольцо на целевом штыре

            //проверка наличия колец на исходном штыре
            if (movingRing == 0) {
                System.out.printf("На %d-м штыре нет колец!!\n", fromPin + 1);
                continue;
            }

            //проверка основого правила игры (на мелкое кольцо нельзя класть большое)
            if ((lastRingAtDest > 0) && (movingRing > lastRingAtDest)) {
                System.out.printf("Класть большее кольцо (%d) на меньшее (%d) запрещено!\n", movingRing, lastRingAtDest);
                continue;
            }

            moveRing(fromPin, toPin);
            break;
        }
    }

    //получить верхнее кольцо на штыре (если штырь пустой - вернуть 0)
    private byte getTopRing(byte pinIndex) {
        byte lastRingIndex = pinTopIndeces[pinIndex];
        if (lastRingIndex >= 0)
            return playField[lastRingIndex][pinIndex];
        else
            return 0;
    }

    //перемещение кольца с одного штыря на другой
    private void moveRing(byte fromPin, byte toPin) {
        byte ring = playField[pinTopIndeces[fromPin]][fromPin];

        playField[pinTopIndeces[fromPin]][fromPin] = 0;
        pinTopIndeces[fromPin]--;

        pinTopIndeces[toPin]++;
        playField[pinTopIndeces[toPin]][toPin] = ring;
    }

    //выиграна ли партия
    private boolean isDone() {
        if (pinTopIndeces[pinsCnt - 1] == ringsCnt - 1) {       //проверка, все ли кольца на последнем штыре
            //проверка возрастающего порядка колец на последнем штыре
            for (int i = 0; i < ringsCnt - 1; i++) {
                if (playField[i][pinsCnt - 1] < playField[i + 1][pinsCnt - 1])
                    return false;
            }
            return true;
        }
        else
            return false;
    }
}