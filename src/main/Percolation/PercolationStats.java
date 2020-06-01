/* *****************************************************************************
 *  Name: Anasthasia Manu
 *  Date: 19/04/2020
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final double[] openSites;
    private final double constant;
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
           throw new IllegalArgumentException();
        }
        this.openSites = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);
                percolation.open(row, col);
            }
            openSites[i] = (double) percolation.numberOfOpenSites() / (n * n);
        }
        constant = ((1.96 * stddev())/Math.sqrt(trials));
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(openSites);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(openSites);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - constant;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {

        return mean() + constant;
    }

    public static void main(String[] args) {
//        int n = Integer.parseInt(args[0]);
//        int trials = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(200, 100);
        StdOut.printf("mean                    = %f%n", ps.mean());
        StdOut.printf("stddev                    = %f%n", ps.stddev());
        StdOut.println("95% confidence interval                    = [" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]");
    }
}
