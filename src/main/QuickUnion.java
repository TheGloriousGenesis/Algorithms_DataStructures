package main;

public class QuickUnion {
    private int[] ids;
    private int[] numberOfObjInTreeNode;

    public QuickUnion(final int n) {
        this.ids = new int[n];
        this.numberOfObjInTreeNode = new int[n];
        for(int i=0; i<ids.length; i++) {
            ids[i] = i;
        }
        for(int i=0; i<numberOfObjInTreeNode.length; i++) {
            numberOfObjInTreeNode[i] = 1;
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
        int idQ = root(q);
        int idP = root(p);
        if(idQ == idP) {
            return;
        }
        if(numberOfObjInTreeNode[idP] < numberOfObjInTreeNode[idQ]) {
            ids[p] = idQ;
            numberOfObjInTreeNode[idQ] += numberOfObjInTreeNode[idP];
        } else {
            ids[q] = idP;
            numberOfObjInTreeNode[idP] += numberOfObjInTreeNode[idQ];
        }
    }

    public boolean find(final int p, final int q) {
        if (q >= ids.length || p >= ids.length) {
            return false;
        }
        int idQ = root(q);
        int idP = root(p);
        return  idP == idQ;
    }


    private int root(final int element) {
        int parent = ids[element];
        while(!(parent == element)) {
            // keeps tree flatter by assigning grandparent to parent at every other pass
            ids[parent] = ids[ids[parent]];
            parent = ids[parent];
        }
        return parent;
    }

    private int rootTwoPass(int element) {
        int parent = ids[element];
        while(!(parent == element)) {
            parent = ids[parent];
        }
        while(!(ids[element] == parent)) {
            int temp = ids[element];
            ids[element] = parent;
            element = temp;
        }
        return parent;
    }
}
