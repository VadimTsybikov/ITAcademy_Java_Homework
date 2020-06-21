package color;

public class Color {
    //константы кодов цветов
    private final int RED = 1;
    private final int ORANGE = 2;
    private final int YELLOW = 3;
    private final int GREEN = 4;
    private final int BLUE = 5;
    private final int INDIGO = 6;
    private final int VIOLET = 7;

    //цвет текущего объекта
    private int colorCode;

    //конструктор с параметром
    public Color(int colorCode) {
        this.colorCode = colorCode;
    }

    //возвращает код цвета объекта
    public int getNumber() {
        return colorCode;
    }

    //возвращает название цвета объекта по коду цвета
    public String getName() {
        switch (colorCode) {
            case RED:
                return "красный";
            case ORANGE:
                return "оранжевый";
            case YELLOW:
                return "желтый";
            case GREEN:
                return "зеленый";
            case BLUE:
                return "голубой";
            case INDIGO:
                return "синий";
            case VIOLET:
                return "фиолетовый";
            default:
                return "неизвестно";
        }
    }
}