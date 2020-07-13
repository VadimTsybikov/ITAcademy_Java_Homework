import core.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class CollectionsMain {
    public static void main(String[] args) {
        WorkWithLinkedList();
        WorkWithArrayList();
    }

    //работа с LinkedList<Person>
    private static void WorkWithLinkedList() {
        //заполнение 1.000.000 элементами
        long personsFillStart = System.currentTimeMillis();
        LinkedList<Person> persons = new LinkedList();
        for (int i = 0; i < 1_000_000; i++) {
            persons.add(new Person(RandomString.random(8), RandomString.random(8)));
        }
        long personsFillEnd = System.currentTimeMillis();
        long personsFillTimeout = personsFillEnd - personsFillStart;
        System.out.println("Время заполнения LinkedList<Person> (элементов " + persons.size() + "): " + personsFillTimeout);    // 3671 ms

        //сортировка компаратором PersonPassLengthComparator
        persons.sort(new PersonPassLengthComparator());

        //очистка через Iterator
        Iterator<Person> iterator = persons.iterator();
        long personsClearStart = System.currentTimeMillis();
        while (iterator.hasNext()) {
            persons.remove(0);
            iterator = persons.iterator();
        }
        long personsClearEnd = System.currentTimeMillis();
        long personsClearTimeout = personsClearEnd - personsClearStart;
        System.out.println("Время очистки LinkedList<Person> (элементов " + persons.size() + "): " + personsClearTimeout);    // 47 ms
    }

    //работа с ArrayList<Animal>
    private static void WorkWithArrayList() {
        //заполнение 1.000.000 элементами
        long animalsFillStart = System.currentTimeMillis();
        ArrayList<Animal> animals = new ArrayList();
        Random randomGen = new Random();
        for (int i = 0; i < 1_000_000; i++) {
            animals.add(new Animal((byte)randomGen.nextInt(), RandomString.random(8)));
        }
        long animalsFillEnd = System.currentTimeMillis();
        long animalsFillTimeout = animalsFillEnd - animalsFillStart;
        System.out.println("Время заполнения ArrayList<Animal> (элементов " + animals.size() + "): " + animalsFillTimeout);     // 418 ms

        //сортировка компаратором AnimalAgeComparator
        animals.sort(new AnimalAgeComparator());

        //очистка циклом while
        long animalsClearStart = System.currentTimeMillis();
        while (animals.size() > 0) {
            animals.remove(0);
        }
        long animalsClearEnd = System.currentTimeMillis();
        long animalsClearTimeout = animalsClearEnd - animalsClearStart;
        System.out.println("Время очистки ArrayList<Animal> (элементов " + animals.size() + "): " + animalsClearTimeout);       // 138026 ms
    }
}