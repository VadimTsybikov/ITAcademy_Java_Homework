package ComputerSim;

import java.util.Random;

public class PC {
    private CPU cpu;
    private CMOS cmos;
    private GraphicAdapter gpu;
    private RAM ram;
    private COM com;
    private HDD hdd;
    private Random random;

    public PC() {
        cpu = new CPU();
        cmos = new CMOS();
        gpu = new GraphicAdapter();
        ram = new RAM();
        com = new COM();
        hdd = new HDD();
        random = new Random();
    }

    /**
     * Метод запускает ПК. Последовательно проверяются и запускаются периферийные устройства.
     * Если все тесты прошли - происходит попытка запуска ОС. Генерируется случайное число.
     * Если число < 8 - система загрузилась, возвращается true.
     * Иначе - BSOD с соответствующим кодом ошибки, возвращается false.
     * Если какой-то тест не прошел - дальнейшая проверка и загрузка ОС не производится, возвращается false.
     */
    public boolean turnOn() {
        System.out.println("System check up:");
        if (cpu.selfTest() && cmos.checksumVerify() && ram.initialTest() && gpu.selfTest() &&
                ram.selfTest() && cmos.selfTest() && com.selfTest() && hdd.selfTest()) {
            System.out.println("System loading...");

            int errorCode = Math.abs(random.nextInt()) % 10;
            if (errorCode < 8) {
                return true;
            }
            else {
                System.out.printf("Blue screen of death. Error code: 0x%08X\n", errorCode);
                return false;
            }
        }
        else {
            return false;
        }
    }
}
