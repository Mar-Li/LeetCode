import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by lifengshuang on 10/20/15.
 */

public class _149_Max_Points_on_a_Line {

    public int maxPoints(Point[] points) {

        if (points.length == 0) {
            return 0;
        }

        ArrayList<Line> lines = new ArrayList<>();

        for (Point point1 : points) {
            for (Point point : points) {
                lines.add(new Line(point1, point));
            }
        }
        for (Point point : points) {
            for (Line line : lines) {
                line.pointOnLine(point);
            }
        }
        int result = 1;
        for (Line line : lines) {
            if (line.count > result) {
                result = line.count;
            }
        }

        return result;
    }


}

class Line {
    Point point1;
    Point point2;
    int count;

    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public void pointOnLine(Point point) {
        if (point1.x == point2.x && point1.y == point2.y) {
            if (point.x == point1.x && point.y == point1.y) {
                count++;
                return;
            } else {
                return;
            }
        }
        if ((point.x - point1.x) * (point1.y - point2.y) == (point.y - point1.y) * (point1.x - point2.x)) {
            count++;
        }
    }
}

class Point {
    int x;
    int y;

    Point(int a, int b) {
        x = a;
        y = b;
    }
}
