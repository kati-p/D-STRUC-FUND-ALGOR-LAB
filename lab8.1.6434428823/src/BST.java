class BST {
    private BTNode root;

    BST() {
        this.root = null;
    }

    /**
     * @return the root
     */
    private BTNode getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    private void setRoot(BTNode root) {
        this.root = root;
    }

    /**
     * @param newElement the element
     */
    public void add(int newElement) {
        BTNode start = root, pre = null;
        BTNode tmp = new BTNode(newElement, null, null);
        if (root == null)
            root = tmp;
        else {
            while (start != null) {
                pre = start;
                int BTNode = start.getElement();
                if (BTNode == newElement) {
                    return;
                } else {
                    if (BTNode > newElement)
                        start = start.getLeft();
                    else
                        start = start.getRight();
                }
            }
            int curNode = pre.getElement();
            if (curNode > newElement)
                pre.setLeft(tmp);
            else if (curNode < newElement)
                pre.setRight(tmp);
        }
    }

    /**
     * print the tree
     * - inOrder
     */
    public void printTree() {
        BTNode r = root;
        inOrder(r);
    }

    /**
     * print in order
     *
     * @param r the root
     */
    public void inOrder(BTNode r) {
        if (r != null) {
            inOrder(r.getLeft());
            System.out.print(r.getElement() + ",");
            inOrder(r.getRight());
        }
    }


}