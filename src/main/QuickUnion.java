package main;

public class QuickUnion {
    private int[] ids;

    public QuickUnion(final int n) {
        this.ids = new int[n];
        for(int i=0; i<ids.length; i++) {
            ids[i] = i;
        }
    }

    /**
     * Uses element value as reference to parent node of index. For connection
     * updates p with root of q by looping through parent nodes of elements until q root
     * reached
     * @param p: int
     *         node value
     * @param q : int
     *          node value
     */
    public void connect(final int p, final int q){
        if (q >= ids.length || p >= ids.length) {
            return;
        }
        int idQ = ids[q];
        while(!(idQ == q)) {
            idQ = ids[idQ];
        }
        ids[p] = idQ;
    }

    public boolean find(final int p, final int q) {
        if (q >= ids.length || p >= ids.length) {
            return false;
        }
        int idQ = ids[q];
        while(!(idQ == q)) {
            idQ = ids[idQ];
        }
        int idP = ids[p];
        while(!(idP == p)) {
            idP = ids[idP];
        }
        return  idP == idQ;
    }
}
