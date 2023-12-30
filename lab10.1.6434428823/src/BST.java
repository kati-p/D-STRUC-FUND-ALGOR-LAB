

class BST {
    protected BTNode root;

    BST(){
        this.root=null;
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

    public void add(int newElement) {
        BTNode start = root, pre = null;
        BTNode tmp = new BTNode(newElement, null, null);
        if (root == null)
            root = tmp;
        else {
            while (start != null) {
                pre = start;
                if (start.getElement() == newElement) {
                    return;
                } else {
                    if (start.getElement() > newElement)
                        start = start.getLeft();
                    else
                        start = start.getRight();
                }
            }
            if (pre.getElement() > newElement)
                pre.setLeft(tmp);
            else if (pre.getElement() < newElement)
                pre.setRight(tmp);
        }
    }

    public int getMax() {
        BTNode start = root;
        if (root == null) return 0;
        while (start.getRight() != null) {
            start = start.getRight();
        }
        return start.getElement();
    }

    public void remove(int newElement) {
        BTNode pre, start;
        pre = start = root;
        while (start != null && start.getElement() != newElement) {
            pre = start;
            if (newElement > start.getElement())
                start = start.getRight();
            else
                start = start.getLeft();
        }
        if (start == null) {
            System.out.println("Data not found");
            return;
        }
        if (start.getRight() == null && start.getLeft() == null) {
            if (start == root) root = null;
            else if (pre.getRight() == start)
                pre.setRight(null);
            else
                pre.setLeft(null);
        } else if (start.getRight() != null && start.getLeft() != null) {
            pre = start;
            BTNode tmp = start.getLeft();
            while (tmp.getRight() != null) {
                pre = tmp;
                tmp = tmp.getRight();
            }
            start.setElement(tmp.getElement());
            if (pre != start) pre.setRight(tmp.getLeft());
            else pre.setLeft(tmp.getLeft());
        } else {
            if (start == root) {
                if (root.getRight() != null)
                    root.setRight(root.getRight());
                else
                    root.setLeft(root.getLeft());
            } else if (pre.getRight() == start) {
                if (start.getRight() != null)
                    pre.setRight(start.getRight());
                else
                    pre.setRight(start.getLeft());
            } else {
                if (start.getRight() != null)
                    pre.setLeft(start.getRight());
                else
                    pre.setLeft(start.getRight());
            }
        }
    }

    public void printTree(){
        BTNode r = root;
        inOrder(r);
        System.out.println();
    }

    public void inOrder(BTNode r) {
        if (r != null) {
            inOrder(r.getLeft());
            System.out.print(r.getElement() + ",");
            inOrder(r.getRight());
        }
    }
}