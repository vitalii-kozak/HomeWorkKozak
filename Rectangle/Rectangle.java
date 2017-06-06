package Rectangle;

public class Rectangle {

    private final double heght;
    private final double width;
    private final double perimeter;
    private final double area;

    public Rectangle(double heght, double width) {
        checkSides(heght, width);

        this.heght = heght;
        this.width = width;
        this.perimeter = 2 * (heght + width);
        this.area = heght * width;
    }

    public double getPerimeter() {return perimeter;}

    public double getArea() {return area;}

    private void checkSides(double heght, double width) {
        if (!areSides(heght, width)) {
            throw new IllegalArgumentException("illegal age: " + width + " or "+ width);
        }
    }

    private boolean areSides(double heght, double width) {
        return heght > 0 && width > 0;
    }

    @Override
    public String toString() {
        return "Rectangle.Rectangle{" +
                "perimeter='" + perimeter + '\'' +
                ", area=" + area +
                '}';
    }

}
