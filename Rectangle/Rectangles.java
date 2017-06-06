package Rectangle;

import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * Created by Tigra on 26.05.2017.
 */
public class Rectangles {

    private final ArrayList<Rectangle> rectangles = new ArrayList<>();

    public void add(Rectangle rectangle) {
        rectangles.add(rectangle);
    }

    public int rectanglesSum() {
        int sum = 0;
        for (Rectangle rectangle : rectangles) {
            sum += rectangle.getArea();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        for (Rectangle rectangle : rectangles) {
            joiner.add(rectangle.toString());
        }
        return "Rectangle.Rectangles:\n" + joiner.toString();
    }
}
