package datastr;

public class DenseMatrix implements Matrix {

    private DenseVector[] rows;

    public DenseMatrix(int r, int c) {
        rows = new DenseVector[r];
        for (int i = 0; i < r; i++)
            rows[i] = new DenseVector(c);
    }

    @Override
    public int numRows() {
        return rows.length;
    }

    @Override
    public int numCols() {
        return rows[0].length();
    }

    @Override
    public void set(int r, int c, double v) {
        assertInRange(r, c);
        rows[r].set(c, v);
    }

    @Override
    public double get(int r, int c) {
        assertInRange(r, c);
        return rows[r].get(c);
    }

    private void assertInRange(int r, int c) {
        if (r < 0 || r >= numRows() || c < 0 || c >= numCols())
            throw new IndexOutOfBoundsException(r + "," + c);
    }

    @Override
    public Matrix add(Matrix m2) {
        DenseMatrix m1 = this;
        if (m1.numRows() != m2.numRows() || m1.numCols() != m2.numCols())
            throw new IllegalArgumentException();
        DenseMatrix m3 = new DenseMatrix(numRows(), numCols());
        for (int i = 0; i < m3.numRows(); i++) {
            for (int j = 0; j < m3.numCols(); j++) {
                m3.set(i, j, m1.get(i, j) + m2.get(i, j));
            }
        }
        return m3;
    }

    @Override
    public Vector multiply(Vector v) {
        if (v.length() != numCols())
            throw new IllegalArgumentException();
        DenseVector r = new DenseVector(numRows());
        for (int i = 0; i < numRows(); i++) {
            r.set(i, rows[i].dot(v));
        }
        return (Vector) r;

    }

    @Override
    public Matrix multiply(Matrix m2) {
        DenseMatrix m1 = this;
        if (m1.numCols() != m2.numRows())
            throw new IllegalArgumentException();
        DenseMatrix m3 = new DenseMatrix(m1.numRows(), m2.numCols());
        for (int i = 0; i < m1.numRows(); i++) {
            m3.rows[i] = m1.rows[i].multiply(m2);
        }
        return m3;
    }

}
