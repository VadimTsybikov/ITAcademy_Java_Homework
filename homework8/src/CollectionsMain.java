import core.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class CollectionsMain {
    public static void main(String[] args) {
        workWithLinkedList();
        workWithArrayList();
    }

    //работа с LinkedList<Person>
    private static void workWithLinkedList() {
        //заполнение 1.000.000 элементами
        Stopwatch.start();      //запуск секундомера
        LinkedList<Person> persons = new LinkedList();
        for (int i = 0; i < 1_000_000; i++) {
            persons.add(new Person(RandomString.random(8), RandomString.random(8)));
        }
        Stopwatch.stop();       //остановка секундомера
        System.out.println("Время заполнения LinkedList<Person> (элементов " + persons.size() + "): " + Stopwatch.getTimePass());    // 3671 ms

        //сортировка компаратором PersonPassLengthComparator
        persons.sort(new PersonPassLengthComparator());

        //очистка через Iterator
        Iterator<Person> iterator = persons.iterator();
        Stopwatch.start();      //запуск секундомера
        while (iterator.hasNext()) {
            persons.remove(0);
            iterator = persons.iterator();
        }
        Stopwatch.stop();       //остановка секундомера
        System.out.println("Время очистки LinkedList<Person> (элементов " + persons.size() + "): " + Stopwatch.getTimePass());    // 47 ms
    }

    //работа с ArrayList<Animal>
    private static void workWithArrayList() {
        //заполнение 1.000.000 элементами
        Stopwatch.start();      //запуск секундомера
        ArrayList<Animal> animals = new ArrayList();
        Random randomGen = new Random();
        for (int i = 0; i < 1_000_000; i++) {
            animals.add(new Animal((byte)randomGen.nextInt(), RandomString.random(8)));
        }
        Stopwatch.stop();       //остановка секундомера
        System.out.println("Время заполнения ArrayList<Animal> (элементов " + animals.size() + "): " + Stopwatch.getTimePass());     // 418 ms

        //сортировка компаратором AnimalAgeComparator
        animals.sort(new AnimalAgeComparator());

        //очистка циклом while
        Stopwatch.start();      //запуск секундомера
        while (animals.size() > 0) {
            animals.remove(0);
        }
        Stopwatch.stop();       //остановка секундомера
        System.out.println("Время очистки ArrayList<Animal> (элементов " + animals.size() + "): " + Stopwatch.getTimePass());       // 138026 ms
    }
}