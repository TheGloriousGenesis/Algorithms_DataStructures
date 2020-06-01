/* *****************************************************************************
 *  Name: Anasthasia Manu
 *  Date: 19/04/2020
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final boolean[] sites;
    private final int n;
    private final int virtualTop;
    private final int virtualBottom;
    private int openSites = 0;
    private final WeightedQuickUnionUF uf;
    private final WeightedQuickUnionUF uf1;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        this.sites = new boolean[n * n + 2];
        this.uf = new WeightedQuickUnionUF((n * n) + 2);
        this.uf1 = new WeightedQuickUnionUF((n * n) + 1);
        // use tail two positions in uf array as placeholder for top/bottom
        this.virtualTop = 0;
        this.virtualBottom = n * n + 1;

        sites[0]=true;

        for (int i = 1;  i <= n; i++) {
            uf.union(virtualTop, getFlatMapId(1,i));
            uf1.union(virtualTop, getFlatMapId(1,i));
            uf.union(virtualBottom, getFlatMapId(n, i));
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(final int realRow, final int realCol) {
        checkBoundaries(realRow, realCol);
        if (isOpen(realRow, realCol)) {
            return;
        }
        if (isSite(realRow + 1, realCol) && isOpen(realRow + 1, realCol)) {
            uf.union(getFlatMapId(realRow, realCol), getFlatMapId(realRow + 1, realCol));
            uf1.union(getFlatMapId(realRow, realCol), getFlatMapId(realRow + 1, realCol));
        }
        if (isSite(realRow - 1, realCol) && isOpen(realRow - 1, realCol)) {
            uf.union(getFlatMapId(realRow, realCol), getFlatMapId(realRow - 1, realCol));
            uf1.union(getFlatMapId(realRow, realCol), getFlatMapId(realRow - 1, realCol));
        }
        if (isSite(realRow, realCol + 1) && isOpen(realRow, realCol + 1)) {
            uf.union(getFlatMapId(realRow, realCol), getFlatMapId(realRow, realCol + 1));
            uf1.union(getFlatMapId(realRow, realCol), getFlatMapId(realRow, realCol + 1));
        }
        if (isSite(realRow, realCol - 1) && isOpen(realRow, realCol - 1)) {
            uf.union(getFlatMapId(realRow, realCol), getFlatMapId(realRow, realCol - 1));
            uf1.union(getFlatMapId(realRow, realCol), getFlatMapId(realRow, realCol - 1));
        }
        sites[getFlatMapId(realRow, realCol)] = true;
        if (realRow == n) {
            sites[virtualBottom] = true;
        }
        openSites++;
    }

    private boolean isSite(int i, int j) {
        if ((i < 1) || (i > n)) {
            return false;
        }
        return (j >= 1) && (j <= n);
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkBoundaries(row,col);
        return sites[getFlatMapId(row, col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        checkBoundaries(row, col);
        return isOpen(row, col) && (virtualTop == uf.find(getFlatMapId(row, col)));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        int top = uf.find(virtualTop);
        int bottom = uf.find(virtualBottom);
        return sites[virtualBottom] && (top == bottom);
    }

    private int getFlatMapId(final int row, final int col) {
        return col + ((row - 1) * n);
    }

    private void checkBoundaries(int row, int col) {
        if (row > n || col > n || row < 1 || col < 1) {
            throw new IllegalArgumentException();
        }
    }

    private void grid() {
        for (boolean site : sites) {
            System.out.printf(" %d ", site ? 1 : 0);
        }
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation percolation = new Percolation(3);
        percolation.open(1, 1);
        percolation.grid();
        System.out.println(percolation.percolates());
        percolation.open(2, 1);
        percolation.grid();
        System.out.println(percolation.percolates());
        percolation.open(3, 1);
        percolation.grid();
        System.out.println(percolation.openSites);
        System.out.println(percolation.percolates());
    }
}