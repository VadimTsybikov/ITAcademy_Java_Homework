package ComputerSim;

public class HDD extends PeripheralBase {
    public HDD() {
    }

    /**
     * Метод проверяет работу контроллера винчестера. Вызывается метод запуска теста базового класса PeripheralBase
     */
    public boolean selfTest() {
        return executeTest("\tcheck HDD... ");
    }
}
