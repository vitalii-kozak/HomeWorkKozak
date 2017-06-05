/**
 * Created by Tigra on 26.05.2017.
 */
public class LineRunner {
    public static void main(String[] args) {
        Line line = new Line(new Point(1,1),new Point(4,1));

        System.out.println(line.toString());

        Lines lines = new Lines();
        lines.add(new Line(new Point(1,1),new Point(4,1)));
        lines.add(new Line(new Point(1,1),new Point(4,6)));
        lines.add(new Line(new Point(1,1),new Point(4,2)));
        lines.add(new Line(new Point(1,1),new Point(4,4)));

        System.out.println(lines);
        System.out.println(lines.lengthSum());
        System.out.println(lines.longestLine());
    }
}
