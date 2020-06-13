package ComputerSim;

public class GraphicAdapter extends PeripheralBase {
    public GraphicAdapter() {
    }

    /**
     * Метод проверяет работу контроллера видеоадаптера. Вызывается метод запуска теста базового класса PeripheralBase
     */
    public boolean selfTest() {
        return executeTest("\tcheck graphic adapter... ");
    }
}
