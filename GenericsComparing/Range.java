package GenericsComparing;


public class Range <T extends Number & Comparable<T>> {
    private final Pair<T ,T> pair;

    public Range(T left, T right) {
        this.pair = new Pair <T, T> (left, right);
    }

    public T getLeft() {
        return pair.getLeft();
    }

    public T getRight() {
        return pair.getRight();
    }

    @Override
    public String toString() {
        return "Range{" +
                "pair=" + pair +
                '}';
    }

    public  <T extends Number & Comparable<T>> void checkPair() throws  IllegalArgumentException {
        if (pair.getRight().compareTo(pair.getLeft()) < 0) {
            throw new IllegalArgumentException("!!! Left is more than right.");
        }
        else if (pair.getRight().compareTo(pair.getLeft()) == 0) {
            throw new IllegalArgumentException("!!! Left equals Right.");
        }
    }

    public  <T extends Number & Comparable<T>> void checkRange(T left, T right) throws  IllegalArgumentException {
        if (right.compareTo(left) < 0) {
            throw new IllegalArgumentException("!!! Left is more than right.");
        }
        else if (right.compareTo(left) == 0) {
            throw new IllegalArgumentException("!!! Left equals Right.");
        }
    }
}
