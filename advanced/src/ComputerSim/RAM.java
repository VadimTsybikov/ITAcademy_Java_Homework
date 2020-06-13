package ComputerSim;

public class RAM extends PeripheralBase {
    public RAM() {
    }

    /**
     * Метод проверяет первые 64 байт ОЗУ. Вызывается метод запуска теста базового класса PeripheralBase
     */
    public boolean initialTest() {
        return executeTest("\tcheck low RAM... ");
    }

    /**
     * Метод проверяет работу ОЗУ. Вызывается метод запуска теста базового класса PeripheralBase
     */
    public boolean selfTest() {
        return executeTest("\tcheck RAM... ");
    }
}
