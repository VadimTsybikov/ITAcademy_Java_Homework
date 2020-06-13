package ComputerSim;

public class CMOS extends PeripheralBase {
    public CMOS() {
    }

    /**
     * Метод проверяет корректность контрольной суммы программы ПЗУ. Вызывается метод запуска теста базового класса PeripheralBase
     */
    public boolean checksumVerify() {
        return executeTest("\tverify CMOS checksum... ");
    }

    /**
     * Метод проверяет работу BIOS. Вызывается метод запуска теста базового класса PeripheralBase
     */
    public boolean selfTest() {
        return executeTest("\tcheck CMOS... ");
    }
}
