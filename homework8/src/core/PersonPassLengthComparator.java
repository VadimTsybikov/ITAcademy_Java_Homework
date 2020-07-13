package core;

import java.util.Comparator;

public class PersonPassLengthComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int passLen1 = o1.getPassword().length();
        int passLen2 = o2.getPassword().length();

        if (passLen1 < passLen2)
            return -1;
        else if (passLen1 > passLen2)
            return 1;
        else
            return 0;
    }
}