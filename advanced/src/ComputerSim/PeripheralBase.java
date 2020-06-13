package ComputerSim;

import java.util.Random;

public class PeripheralBase {
    protected Random random;

    public PeripheralBase() {
        random = new Random();
    }

    /**
     * Метод запускает тест с указанным сообщением.
     * Генерируется случайное число. Если число < 8 - тест пройден, возвращается true.
     * Иначе - вывод кода ошибки, возвращается false.
     */
    protected boolean executeTest(String _details) {
        System.out.print(_details);

        int errorCode = Math.abs(random.nextInt()) % 10;
        if (errorCode < 8) {
            System.out.println("OK");
            return true;
        }
        else {
            System.out.printf("Failed. Error code: 0x%08X\n", errorCode);
            return false;
        }
    }
}
