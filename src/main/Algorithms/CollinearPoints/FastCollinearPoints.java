package CollinearPoints;

import CollinearPoints.LineSegment;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FastCollinearPoints {
    private final List<LineSegment> lines = new ArrayList<>();
    public FastCollinearPoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        }
        int n = points.length;
        for (int index = 0; index < n - 1; index++) {
            if (points[index] == null) {
                throw new IllegalArgumentException();
            }
        }
        Point[] clone = points.clone();
        Arrays.sort(clone);
        for (int index = 0; index < n - 1; index++) {
            if (clone[index].toString().equals(clone[index + 1].toString())) {
                throw new IllegalArgumentException();
            }
        }        

        for (int i = 0; i < n; i++) {
            Point origin = clone[0];
            Point[] sortedSlopes = clone.clone();
            Arrays.sort(sortedSlopes, origin.slopeOrder());
            int count = 1;
            while (count < n) {
                LinkedList<Point> list = new LinkedList<>();
                double slope1 = origin.slopeTo(points[i]);
                do {
                    list.add(sortedSlopes[count++]);
                } while (count < n && origin.slopeTo(sortedSlopes[count]) == slope1);

                if (list.size() >= 3 && origin.compareTo(list.peek()) < 0) {
                    lines.add(new LineSegment(origin, list.remove()));
                }
            }
        }
    }
    public int numberOfSegments() {
        return lines.size();
    }
    public LineSegment[] segments() {
        LineSegment[] lineSegment = new LineSegment[lines.size()];
        return lines.toArray(lineSegment);
    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}