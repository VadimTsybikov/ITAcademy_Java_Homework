package ComputerSim;

public class COM extends PeripheralBase {
    public COM() {
    }

    /**
     * Метод проверяет работу COM-порта. Вызывается метод запуска теста базового класса PeripheralBase
     */
    public boolean selfTest() {
        return executeTest("\tcheck COM... ");
    }
}
