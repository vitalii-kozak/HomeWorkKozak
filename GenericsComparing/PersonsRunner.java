package GenericsComparing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PersonsRunner {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(Arrays.asList(new Person("Vitalii",38),new Person("Barbara",16),
                new Person("Kate",14), new Person("Natalia",37), new Person("Nikolay",13), new Person("Mia",13)));

        Persons.printList(persons);

        Persons.printList(Persons.sortTeenagers(persons));
    }
}

