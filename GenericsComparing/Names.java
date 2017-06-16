package GenericsComparing;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Names {

    public static void printList(List<String> list) {
        System.out.print("{ ");
        for (String l: list) {
            System.out.print(l+" ");
        }
        System.out.println("}");
    }

    public static void sortAlfabet (List<String> list) {
        System.out.println("Alphabetical order sorting:");
        Collections.sort(list);
        printList(list);
    }

    public static void findShortestNameAlfabet (List<String> list) {
        System.out.println("The shortest name is " + Collections.min(list,new NamesComparator()));
    }

    public static void sortReverse (List<String> list) {
        System.out.println("Reverse order sorting:");
        Collections.sort(list,Collections.reverseOrder());
        printList(list);
    }

    public static void sortByNamesSize (List<String> list) {
        System.out.println("Sorting by names size:");
        Collections.sort(list,new NamesComparator());
        printList(list);

    }

    public static void sortReverseGroupBySize (List<String> list) {
        System.out.println("Sorting by name size in reverse order:");
        Collections.sort(list,new GroupReverseComparator());
        printList(list);
    }

}

class NamesComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(),o2.length());
    }
}

class GroupReverseComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        int i =  Integer.compare(o1.length(), o2.length());

        if(i == 0) {
            return o2.compareTo(o1);
        }
        else {
            return i;
        }
    }
}