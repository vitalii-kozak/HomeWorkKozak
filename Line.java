/**
 * Created by Tigra on 26.05.2017.
 */
public class Line {
    private final Point start;
    private final Point end;
    private final double length;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.length = Math.sqrt(Math.pow((end.getX()-start.getX()),2) + Math.pow((end.getY() - start.getY()),2));
    }

    public double getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Line (" + start + " " + end + " " + ", length=" + length +")";
    }
}
