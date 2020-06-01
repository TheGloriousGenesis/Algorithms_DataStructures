import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation2 {

    private int[][] sites;
    private int[] flatSites;
    private int[] rootTreeMap;
    private int n;
    private int virtualTop = -1;
    private int virtualBottom = -2;
    private int openSites = 0;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation2(int n) {
        if (n <=0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        this.sites = new int[n][n];
        this.flatSites = new int[(n * n) + 2];
        this.rootTreeMap = new int[(n * n) + 2];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // populate all sites closed
                sites[i][j] = 0;
            }
        }
        for (int i = 0; i < (n * n) + 2; i++) {
            flatSites[i] = i;
            rootTreeMap[i] = 1;
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        checkBoundaries(row, col);
        sites[row][col] = 1;
        openSites++;
        if (isOpen(row + 1, col)) {
            union(getFlatMapId(row, col), getFlatMapId(row + 1, col));
        }
        if (isOpen(row - 1, col)) {
            union(getFlatMapId(row, col), getFlatMapId(row - 1, col));
        }
        if (isOpen(row, col + 1)) {
            union(getFlatMapId(row, col), getFlatMapId(row, col + 1));
        }
        if (isOpen(row, col - 1)) {
            union(getFlatMapId(row, col), getFlatMapId(row, col - 1));
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkBoundaries(row, col);
        return sites[row][col] == 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        checkBoundaries(row, col);
        return connected(virtualTop, getFlatMapId(row - 1, col - 1));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return connected(virtualTop, virtualBottom);
    }

    private void union(final int p, final int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if (pRoot >= 0 && pRoot <= n -1 && qRoot >= n) {
            flatSites[q] = virtualTop;
        }
        if (qRoot >= 0 && qRoot <= n -1 && pRoot >= n) {
            flatSites[q] = virtualTop;
        }
        if (rootTreeMap[pRoot] < rootTreeMap[qRoot]) {
            flatSites[p] = qRoot;
            rootTreeMap[qRoot] += rootTreeMap[pRoot];
        } else {
            flatSites[q] = pRoot;
            rootTreeMap[pRoot] += rootTreeMap[qRoot];
        }
        percolates();
    }

    private int getFlatMapId(final int row, final int col) {
        return col + n * row;
    }

    private boolean connected(final int p, final int q) {
        if (q >= flatSites.length || p >= flatSites.length) {
            return false;
        }
        int idQ = root(q);
        int idP = root(p);
        return  idP == idQ;
    }

    private int root(final int element) {
        int parent = flatSites[element];
        while (!(parent == element)) {
            flatSites[parent] = flatSites[flatSites[parent]];
            parent = flatSites[parent];
        }
        return parent;
    }

    private void checkBoundaries(int row, int col) {
        if (row > n -1 || col > n -1 || row <= 0 || col <= 0) {
            throw new IllegalArgumentException();
        }
    }
    // test client (optional)
    public static void main(String[] args) {
        Percolation2 percolation2 = new Percolation2(3);
        percolation2.open(1, 1);
        percolation2.open(1, 2);
        assert(percolation2.connected(4, 7));
    }
}