package MyArrayList.core;

public class BoxData<T extends Number> {
    private T[] container;
    private int itemsCnt;

    //конструктор с параметром
    public BoxData(T[] container) {
        this.container = container;
        itemsCnt = container.length;
    }

    //вставка в конец списка
    public void add(T data) {
        if (itemsCnt >= container.length) {
            realloc();
        }
        container[itemsCnt++] = data;
    }

    //вставка в позицию
    public void add(int index, T data) {
        if (index < itemsCnt) {
            if (itemsCnt >= container.length) {
                realloc();
            }

            //смещение все, что правее позиции index, еще правее
            for (int i = itemsCnt - 1; i >= index; i--) {
                container[i + 1] = container[i];
            }

            container[index] = data;
            itemsCnt++;
        }
        else
            throw new ArrayIndexOutOfBoundsException();
    }

    //увеличение размера массива
    private void realloc() {
        T[] newContainer = (T[])new Number[itemsCnt * 3 / 2 + 1];
        for (int i = 0; i < itemsCnt; i++) {
            newContainer[i] = container[i];
        }
        container = newContainer;
    }

    //сериализация массива в строку
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < itemsCnt; i++) {
            str += (str.length() > 0 ? ", " : "") + container[i].toString();
        }
        return "{" + str + "}";
    }
}