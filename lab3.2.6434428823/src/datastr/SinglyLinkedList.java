package datastr;

public class SinglyLinkedList implements List {
    private static class LinkedNode {
        Object element;
        LinkedNode next;

        LinkedNode(Object e, LinkedNode n) {
            this.element = e;
            this.next = n;
        }
    }

    private LinkedNode header;
    private int size;

    public SinglyLinkedList() {
        header = new LinkedNode(null, null);
        size = 0;
    }

    public boolean isEmpty() {
        return header.next == null;
    }

    public int size() {
        return size;
    }

    public boolean contains(Object e) {
        return indexOf(e) >= 0;
    }

    public void add(Object e) {
        add(size, e);
    }

    public void add(int i, Object e) {
        LinkedNode p = nodeAt(i - 1);
        p.next = new LinkedNode(e, p.next);
        ++size;
    }

    private LinkedNode nodeAt(int i) {
        LinkedNode p = header;
        for (int j = -1; j < i; j++) p = p.next;
        return p;
    }

    private void removeAfter(LinkedNode p) {
        if (p.next != null) {
            p.next = p.next.next;
            --size;
        }
    }

    public int indexOf(Object e) {
        LinkedNode p = header.next;
        for (int i = 0; i < size; i++) {
            if (p.element.equals(e)) return i;
            p = p.next;
        }
        return -1;
    }

    public void remove(Object e) {
        LinkedNode p = header;
        while (p.next != null && !p.next.element.equals(e))
            p = p.next;
        removeAfter(p);
    }

    public void remove(int i) {
        LinkedNode p = nodeAt(i - 1);
        removeAfter(p);
    }

    public Object get(int i) {
        return nodeAt(i).element;
    }

    public void set(int i, Object e) {
        nodeAt(i).element = e;
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        LinkedNode p = header.next;
        for (int i = 0; i < size; i++) {
            arr[i] = p.element;
            p = p.next;
        }
        return arr;
    }

    public void swap(int i, int j) {
        LinkedNode prevNode1 = nodeAt(i - 1);
        LinkedNode node1 = prevNode1.next;
        LinkedNode prevNode2 = nodeAt(j - 1);
        LinkedNode nextNode2 = prevNode2.next.next;
        if (i == j - 1) {
            node1.next.next = node1;
            prevNode1.next = node1.next;
            node1.next = nextNode2;
        } else {
            prevNode2.next.next = node1.next;
            prevNode1.next = prevNode2.next;
            prevNode2.next = node1;
            node1.next = nextNode2;
        }
    }

    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            swap(i, size - 1 - i);
        }
    }

    public void removeRange(int ft, int fn) {
        nodeAt(ft - 1).next = nodeAt(fn);
        size = size - (fn - ft);
    }
}
