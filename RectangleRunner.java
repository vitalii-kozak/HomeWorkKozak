/**
 * Created by Tigra on 26.05.2017.
 */
public class RectangleRunner {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(2, 2);

        System.out.println(rectangle.toString());
        Rectangles rectangles = new Rectangles();
        rectangles.add(new Rectangle(1, 1));
        rectangles.add(new Rectangle(2, 2));
        rectangles.add(new Rectangle(3, 3));
        rectangles.add(new Rectangle(4, 4));

        System.out.println(rectangles);
        System.out.println(rectangles.rectanglesSum());
    }
}
