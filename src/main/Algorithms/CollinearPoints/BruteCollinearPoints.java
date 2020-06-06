import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {
    private final List<LineSegment> lines = new ArrayList<>();
    public BruteCollinearPoints(Point[] points)  {
        if (points == null) {
            throw new IllegalArgumentException();
        }
        int n = points.length;
        for (int index = 0; index < n; index++) {
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
        for (int h = 0; h < n; h++) {
            for (int i = h + 1; i < n; i++) {
                double s1 = points[h].slopeTo(points[i]);
                for (int j = i + 1; j < n; j++) {
                    double s2 = points[h].slopeTo(points[j]);
                    if (s2 == s1) {
                        for (int k = j + 1; k  < n; k++) {
                            if (points[h].slopeTo(points[k]) == s1) {
                                lines.add(new LineSegment(points[h], points[k]));
                            }
                        }
                    }
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
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}