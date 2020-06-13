package ComputerSim;

public class Simulator {
    public static void main(String[] args) {
        //инициализируется и запускается объект ПК
        //по результатам запуска выводится либо приветствие, либо сообщение о неработоспособности ПК

        PC pc = new PC();
        if (pc.turnOn()) {
            System.out.println("Welcome!");
        }
        else {
            System.out.println("It doesn't work :(");
        }
    }
}