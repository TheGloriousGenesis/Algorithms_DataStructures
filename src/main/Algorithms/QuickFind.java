public class QuickFind {

    private int[] nodes;

    public QuickFind(final int n) {
        this.nodes = new int[n];
        // set values to equal the array index to instantiate
        for(int i=0; i< n; i++) {
            nodes[i]=i;
        }
    }

    /**
     * for each node connection, change element at node p to q's element
     * @param p :int
     *          node value
     * @param q :int
     *         node value
     */
    public void connect(final int p, final int q) {
        if (p >= nodes.length || q >= nodes.length) {
            return;
        }
        int newConnectId = nodes[q];
        int oldConnectId = nodes[p];
        for(int i=0; i< nodes.length; i++) {
            if (nodes[i]== oldConnectId) {
                nodes[i] = newConnectId;
            }
        }
    }

    public boolean find(final int p, final int q){
        if (p >= nodes.length || q >= nodes.length || q == p) {
            return false;
        }
        return nodes[p] == nodes[q];
    }
}
