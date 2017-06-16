package GenericsComparing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NamesRunner {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>(Arrays.asList("Vitalii", "Barbara", "Kate", "Natalia", "Mia", "Nikolay", "Andy", "Diana"));

        Names.sortAlfabet(names);
        System.out.println();

        Names.sortReverse(names);
        System.out.println();

        Names.sortByNamesSize(names);
        System.out.println();

        Names.sortReverseGroupBySize(names);
        System.out.println();

        Names.findShortestNameAlfabet(names);

    }
}
