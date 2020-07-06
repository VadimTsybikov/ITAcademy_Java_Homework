package MyArrayList;

import MyArrayList.core.BoxData;

public class MyArrayListMain {
    public static void main(String[] args) {
        Integer[] initialArray = new Integer[] { 54, 33, 7, 12, 567, 85 };

        BoxData<Integer> intBox = new BoxData<>(initialArray);
        System.out.println("Состояние BoxData после инициализации: " + intBox.toString());

        int x = 42;
        intBox.add(x);
        System.out.println("Состояние BoxData после добавления " + x + " в конец: " + intBox.toString());

        x = 61;
        int pos = 4;
        intBox.add(pos, x);
        System.out.println("Состояние BoxData после добавления " + x + " в " + pos + "-ю позицию: " + intBox.toString());
    }
}