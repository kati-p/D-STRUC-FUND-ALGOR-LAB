import java.util.Stack;

public class AVLTree extends BST {

    public AVLTree() {
        super();
    }

    public void add(int e) {
        AVLNode tmp = new AVLNode(e,null,null,0,0,0);
        if (root == null)
            root = tmp;
        else {
            AVLNode start = (AVLNode) root;
            Stack st = new Stack();
            while (start != null) {
                st.push(start);
                if (start.getElement() == e)
                    return;
                else if (e > start.getElement())
                    start = (AVLNode) start.getRight();
                else
                    start = (AVLNode) start.getLeft();
            }
            AVLNode pre = (AVLNode) st.pop();
            if (e < pre.getElement())
                pre.setLeft(tmp);
            else
                pre.setRight(tmp);
            updateWeight(pre);
            while (! st.isEmpty()) {
                start = (AVLNode) st.pop();
                updateWeight(start);
                pre = rotate(start, pre, st);
            }
        }
    }

    public void remove(int newElement) {
        AVLNode pre, start;
        pre = start = (AVLNode) root;
        Stack st = new Stack();
        while (start != null && start.getElement() != newElement) {
            pre = start;
            if (newElement > start.getElement())
                start = (AVLNode) start.getRight();
            else
                start = (AVLNode) start.getLeft();
            st.push(start);
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
            AVLNode tmp = (AVLNode) start.getLeft();
            st.push(tmp);
            while (tmp.getRight() != null) {
                pre = tmp;
                st.push(tmp);
                tmp = (AVLNode) tmp.getRight();
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
        st.pop();
        while (!st.isEmpty()) {
            start = (AVLNode) st.pop();
            updateWeight(start);
            if (start.getLeftH() < start.getRightH())
                pre = (AVLNode) start.getRight();
            else
                pre = (AVLNode) start.getLeft();
            rotate(start, pre, st);
        }
    }

    public void updateWeight(AVLNode node) {
        AVLNode r = (AVLNode) node.getRight();
        AVLNode l = (AVLNode) node.getLeft();
        if (r == null)
            node.setRightH(0);
        else
            node.setRightH(1 + Math.max(r.getLeftH(), r.getRightH()));
        if (l == null)
            node.setLeftH(0);
        else
            node.setLeftH((1 + Math.max(l.getLeftH(), l.getRightH())));
        node.setWeight(node.getLeftH() - node.getRightH());
    }

    public AVLNode rotate(AVLNode start, AVLNode pre, Stack st) {
        AVLNode subRoot = start;
        if (Math.abs(start.getWeight()) > 1) {
            if (start.getWeight() > 0) {
                if (pre.getWeight() > 0)
                    subRoot = singleRight(start, pre);
                else
                    subRoot = doubleRight(start, pre);
            } else {
                if (pre.getWeight() < 0)
                    subRoot = singleLeft(start, pre);
                else
                    subRoot = doubleLeft(start, pre);
            }
            if (st.isEmpty())
                root = subRoot;
            else {
                AVLNode preSubRoot = (AVLNode) st.peek();
                if (subRoot.getElement() < preSubRoot.getElement())
                    preSubRoot.setLeft(subRoot);
                else
                    preSubRoot.setRight(subRoot);
            }
        }
        return subRoot;
    }

    public AVLNode singleRight(AVLNode start, AVLNode pre) {
        start.setLeft(pre.getRight());
        pre.setRight(start);
        updateWeight(start);
        updateWeight(pre);
        return pre;
    }

    public AVLNode doubleRight(AVLNode start, AVLNode pre) {
        AVLNode next = (AVLNode) pre.getRight();
        pre.setRight(next.getLeft());
        start.setLeft(next.getRight());
        next.setLeft(pre);
        next.setRight(start);
        updateWeight(start);
        updateWeight(pre);
        updateWeight(next);
        return next;
    }

    public AVLNode singleLeft(AVLNode start, AVLNode pre) {
        start.setRight(pre.getLeft());
        pre.setLeft(start);
        updateWeight(start);
        updateWeight(pre);
        return pre;
    }

    public AVLNode doubleLeft(AVLNode start, AVLNode pre) {
        AVLNode next = (AVLNode) pre.getLeft();
        pre.setLeft(next.getRight());
        start.setRight(next.getLeft());
        next.setLeft(start);
        next.setRight(pre);
        updateWeight(pre);
        updateWeight(start);
        updateWeight(next);
        return next;
    }
}
