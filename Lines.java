import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * Created by Tigra on 26.05.2017.
 */
public class Lines {
    private final ArrayList<Line> lines = new ArrayList<>();

    public void add(Line line) {
        lines.add(line);
    }

    public double lengthSum() {
        double sum = 0;
        for (Line line : lines) {
            sum += line.getLength();
        }
        return sum;
    }

    public  Line longestLine() {
        Line maxLine = null;
        double maxLength = 0;
        for (Line line : lines) {
            if (line.getLength() > maxLength) {
                maxLength =  line.getLength();
                maxLine = line;
            }
        }
        return maxLine;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        for (Line line : lines) {
            joiner.add(line.toString());
        }
        return "Lines:\n" + joiner.toString();
    }
}
