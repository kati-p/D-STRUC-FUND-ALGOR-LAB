package datastr;

public class DenseVector implements Vector {

    private double[] element;
    private int length;

    public DenseVector(int length) {
        this.element = new double[length];
        this.length = length;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public double magnitude() {
        double mag = 0.0;
        for (int i = 0; i < length; i++)
            mag += element[i] * element[i];
        mag = Math.sqrt(mag);
        return mag;
    }

    @Override
    public double get(int index) {
        return element[index];
    }

    @Override
    public void set(int index, double value) {
        element[index] = value;
    }

    @Override
    public Vector add(Vector v2) {
        DenseVector v1 = this;
        if (v1.length() != v2.length())
            throw new IllegalArgumentException();
        DenseVector v3 = new DenseVector(v1.length);
        for (int i = 0; i < v3.length(); i++) {
            v3.set(i, v1.get(i) + v2.get(i));
        }
        return v3;
    }

    @Override
    public Vector subtract(Vector v2) {
        DenseVector v1 = this;
        if (v1.length() != v2.length())
            throw new IllegalArgumentException();
        DenseVector v3 = new DenseVector(v1.length);
        for (int i = 0; i < v3.length(); i++) {
            v3.set(i, v1.get(i) - v2.get(i));
        }
        return v3;
    }

    @Override
    public double dot(Vector v2) {
        double r = 0;
        DenseVector v1 = this;
        if (v1.length() != v2.length())
            throw new IllegalArgumentException();
        for (int i = 0; i < v1.length(); i++)
            r += v1.get(i) * v2.get(i);
        return r;
    }

    @Override
    public DenseVector multiply(double c) {
        DenseVector vr = new DenseVector(length);
        for (int i = 0; i < length; i++)
            vr.set(i, this.element[i] * c);
        return vr;
    }

}
