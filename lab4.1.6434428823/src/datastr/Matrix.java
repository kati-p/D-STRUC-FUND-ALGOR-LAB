package datastr;

public interface Matrix {

    public int numRows();
    public int numCols();
    public void set(int r, int c, double v);
    public double get(int r, int c);
    public Matrix add(Matrix m2);
    public Vector multiply(Vector v);
    public Matrix multiply(Matrix m2);
}
