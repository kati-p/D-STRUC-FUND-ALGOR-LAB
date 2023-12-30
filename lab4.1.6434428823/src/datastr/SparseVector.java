package datastr;

public class SparseVector implements Vector {
    private static class Element {
        int index;
        double value;

        Element(int i, double v) {
            this.index = i;
            this.value = v;
        }
    }

    private int size;
    private int length;
    private Element[] elementData;

    public SparseVector(int length) {
        this.elementData = new Element[0];
        this.size = 0;
        this.length = length;
    }

    public int length() {
        return length;
    }

    @Override
    public double magnitude() {
        double mag = 0.0;
        for (int i = 0; i < size; i++)
            mag += elementData[i].value * elementData[i].value;
        mag = Math.sqrt(mag);
        return mag;
    }

    public double get(int index) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].index == index)
                return elementData[i].value;
            if (elementData[i].index > index) break;
        }
        return 0.0;
    }

    public void set(int index, double value) {
        int i = 0;
        for (; i < size; i++)
            if (elementData[i].index >= index) break;
        if (i < size && elementData[i].index == index)
            elementData[i].value = value;
        else
            add(i, index, value);
    }

    @Override
    public Vector add(Vector v) {
        if (v instanceof SparseVector) return this.add(((SparseVector) v));
        if (v instanceof DenseVector) return this.add(((DenseVector) v));
        return this;
    }

    @Override
    public Vector subtract(Vector v) {
        if (v instanceof SparseVector) return this.subtract(((SparseVector) v));
        if (v instanceof DenseVector) return this.subtract(((DenseVector) v));
        return this;
    }

    private void add(int i, int index, double value) {
        if (value != 0) {
            ensureCapacity(size + 1);
            for (int k = size; k > i; k--)
                elementData[k] = elementData[k - 1];
            elementData[i] = new Element(index, value);
            ++size;
        }
    }

    public double dot(Vector v2) {
        if (this.length != v2.length())
            throw new IllegalArgumentException();
        double r = 0;
        if (v2 instanceof DenseVector) {
            SparseVector v1 = this;
            for (int i = 0; i < v1.length(); i++) {
                r += v1.get(i) * v2.get(i);
            }
        } else if (v2 instanceof SparseVector) {
            SparseVector v1 = this;
            SparseVector v = (SparseVector) v2;
            int i1 = 0, i2 = 0;
            while (i1 < v1.size && i2 < v.size) {
                Element e1 = v1.elementData[i1];
                Element e2 = v.elementData[i2];
                if (e1.index < e2.index) i1++;
                else if (e1.index > e2.index) i2++;
                else {
                    r += e1.value * e2.value;
                    i1++;
                    i2++;
                }
            }
        }
        return r;
    }

    public Vector add(DenseVector v2) {
        SparseVector v1 = this;
        if (v1.length != v2.length())
            throw new IllegalArgumentException();
        DenseVector v3 = new DenseVector(v1.length());
        for (int i = 0; i < v3.length(); i++) {
            v3.set(i, v1.get(i) + v2.get(i));
        }
        return v3;
    }

    public SparseVector add(SparseVector v2) {
        SparseVector v1 = this;
        if (v1.length != v2.length())
            throw new IllegalArgumentException();
        SparseVector v3 = new SparseVector(v1.length());
        int i1 = 0, i2 = 0, i3 = 0;
        while (i1 < v1.size && i2 < v2.size) {
            Element e1 = v1.elementData[i1], e2 = v2.elementData[i2];
            if (e1.index < e2.index) {
                v3.add(i3++, e1.index, e1.value);
                i1++;
            } else if (e1.index > e2.index) {
                v3.add(i3++, e2.index, e2.value);
                i2++;
            } else {
                v3.add(i3++, e1.index, e1.value + e2.value);
                i1++;
                i2++;
            }
        }
        while (i1 < v1.size) {
            Element e1 = v1.elementData[i1++];  //
            v3.add(i3++, e1.index, e1.value);
        }
        while (i2 < v2.size) {
            Element e2 = v2.elementData[i2++];  //
            v3.add(i3++, e2.index, e2.value);
        }
        return v3;
    }

    public Vector subtract(DenseVector v2) {
        SparseVector v1 = this;
        if (v1.length != v2.length())
            throw new IllegalArgumentException();
        DenseVector v3 = new DenseVector(v1.length());
        for (int i = 0; i < v3.length(); i++) {
            v3.set(i, v1.get(i) - v2.get(i));
        }
        return v3;
    }

    public SparseVector subtract(SparseVector v2) {
        SparseVector v1 = this;
        if (v1.length != v2.length())
            throw new IllegalArgumentException();
        SparseVector v3 = new SparseVector(v1.length());
        int i1 = 0, i2 = 0, i3 = 0;
        while (i1 < v1.size && i2 < v2.size) {
            Element e1 = v1.elementData[i1], e2 = v2.elementData[i2];
            if (e1.index < e2.index) {
                v3.add(i3++, e1.index, e1.value);
                i1++;
            } else if (e1.index > e2.index) {
                v3.add(i3++, e2.index, e2.value * (-1));
                i2++;
            } else {
                v3.add(i3++, e1.index, e1.value - e2.value);
                i1++;
                i2++;
            }
        }
        while (i1 < v1.size) {
            Element e1 = v1.elementData[i1++];  //
            v3.add(i3++, e1.index, e1.value);
        }
        while (i2 < v2.size) {
            Element e2 = v2.elementData[i2++];  //
            v3.add(i3++, e2.index, e2.value * (-1));
        }
        return v3;
    }

    public SparseVector multiply(double c) {
        SparseVector v = new SparseVector(this.length);
        for (int i = 0; i < size; i++) {
            v.add(i, elementData[i].index, c * elementData[i].value);
        }
        return v;
    }

    private void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int s = Math.max(capacity, 2 * elementData.length);
            Element[] arr = new Element[s];
            for (int i = 0; i < size; i++)
                arr[i] = elementData[i];
            elementData = arr;
        }
    }

}
