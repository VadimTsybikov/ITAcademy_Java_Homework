package ComputerSim;

public class CPU extends PeripheralBase {
    public CPU() {
    }

    /**
     * Метод проверяет работу процессора. Вызывается метод запуска теста базового класса PeripheralBase
     */
    public boolean selfTest() {
        return executeTest("\tcheck CPU registers... ");
    }
}
