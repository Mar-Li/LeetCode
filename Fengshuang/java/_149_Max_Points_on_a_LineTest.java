import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by lifengshuang on 10/20/15.
 */
public class _149_Max_Points_on_a_LineTest {

    Point p1 = new Point(1, 7);
    Point p2 = new Point(2, 14);
    Point p3 = new Point(3, 21);
    Point p4 = new Point(3, 4);
    Point p5 = new Point(-5, -35);
    Point p6 = new Point(5, 35);

    @Test
    public void testMaxPoints() throws Exception {
        Point[] points = new Point[]{p1, p2, p3, p4, p5, p6};
        _149_Max_Points_on_a_Line test = new _149_Max_Points_on_a_Line();
        int r = test.maxPoints(points);
        assertEquals(r, 5);
    }


//    class Line {
//        Point point1;
//        Point point2;
//        Set<Long> points = new HashSet<>();
//
//        public Line(Point point1, Point point2) {
//            this.point1 = point1;
//            this.point2 = point2;
//            addPoint(point1);
//            addPoint(point2);
//        }
//
//        public boolean equal(Line line) {
//            int x1 = point1.x, y1 = point1.y;
//            int x2 = point2.x, y2 = point2.y;
//            int x1_ = line.point1.x, y1_ = line.point1.y;
//            int x2_ = line.point2.x, y2_ = line.point2.y;
//            int dk = (x1 - x2) * (y1_ - y2_) - (x1_ - x2_) * (y1 - y2);
//            int db = (x1 * y2 - x2 * y1) * (y1_ - y2_) - (x1_ * y2_ - x2_ * y1_) * (y1 - y2);
//            return dk == 0 && db == 0;
//        }
//
//        private void merge(Line line) {
//            addPoint(line.point1);
//            addPoint(line.point2);
//        }
//
//        private void addPoint(Point point) {
//            points.add(((long) (point.x) << 32) + point.y);
//        }
//    }
//
//    class Point {
//        int x;
//        int y;
//
//        Point(int a, int b) {
//            x = a;
//            y = b;
//        }
//    }
}