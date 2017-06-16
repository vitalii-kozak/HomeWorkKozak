package GenericsComparing;

public class RangeRunner {
    public static void main(String[] args) {
        Range range1 = new Range(1.2, 2.1);
        range1.checkRange(range1.getLeft(), range1.getRight());
        System.out.println(range1);

        Range range2 = new Range(1, 3);
        range2.checkPair();
        System.out.println(range2);
    }
}
