package GenericsComparing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Persons {

    public static void printList(List<Person> list) {
        System.out.print("{ ");
        for (Person person: list) {
            System.out.print(person+" ");
        }
        System.out.println("}");
    }

    public static List<Person> sortTeenagers (List<Person> list) {
        List<Person> persons = new ArrayList<>();
        for (Person person : list) {
            if((person.getAge()>=12)&&(person.getAge()<=17)){
                persons.add(person);
            }
        }

        Collections.sort(persons, new PersonsTeenegersComparator());
        return persons;
    }


}

class PersonsTeenegersComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int i =  Integer.compare(o1.getAge(), o2.getAge());

        if(i == 0) {
            return o1.compareTo(o2);
        }
        else {
            return i;
        }
    }
}

