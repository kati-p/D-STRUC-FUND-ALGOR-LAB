package datastr;

public class LinkedCollection implements Collection {
    private static class LinkedNode {
        Object element;
        LinkedNode next;

        LinkedNode(Object e, LinkedNode next) {
            this.element = e;
            this.next = next;
        }
    }

    private LinkedNode header = new LinkedNode(null, null);
    private int size;

    public LinkedCollection() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Object e) {
        header.next = new LinkedNode(e, header.next);
        ++size;
    }

    public boolean contains(Object e) {
        LinkedNode node = header.next;
        while (node != null) {
            if (node.element.equals(e)) return true;
            node = node.next;
        }
        return false;
    }

    public void remove(Object e) {
        LinkedNode p = header;
        while (p.next != null && !p.next.element.equals(e)) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next;
            --size;
        }
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        LinkedNode p = header.next;
        int k = 0;
        while (p != null) {
            arr[k++] = p.element;
            p = p.next;
        }
        return arr;
    }

    public boolean equals(Object o) {
        if (o instanceof LinkedCollection) {
            LinkedNode p = ((LinkedCollection) o).header.next;
            while (p != null && this.contains(p.element)) {
                p = p.next;
            }
            if (p == null) {
                p = header.next;
                while (p != null && ((LinkedCollection) o).contains(p.element)) {
                    p = p.next;
                }
                if (p == null) return true;
            }
        }
        return false;
    }

    public boolean containsDup() {
        LinkedNode p = header.next;
        LinkedNode node;
        while (p != null) {
            node = p.next;
            while (node != null) {
                if (p.element.equals(node.element)) return true;
                node = node.next;
            }
            p = p.next;
        }
        return false;
    }

    public void removeDup() {
        LinkedNode p = header.next;
        LinkedNode node;
        while (p != null) {
            node = p;
            while (node != null && node.next != null) {
                if (p.element.equals(node.next.element)) {
                    node.next = node.next.next;
                    size--;
                }
                node = node.next;
            }
            p = p.next;
        }
    }

    public void removeAll(Object e) {
        while (this.contains(e)) {
            this.remove(e);
        }
    }
}
