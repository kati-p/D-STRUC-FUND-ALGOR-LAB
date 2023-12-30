package lab;

import datastr.DenseMatrix;
import datastr.Matrix;
import datastr.SparseMatrix;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        int r1 = rnd.nextInt(10) + 1;
        int c1 = rnd.nextInt(10) + 1;
        int c2 = rnd.nextInt(10) + 1;

        // create m1
        DenseMatrix m1 = new DenseMatrix(r1, c1);
        for (int i = 0; i < m1.numRows(); i++)
            for (int j = 0; j < m1.numCols(); j++)
                m1.set(i, j, rnd.nextInt(11));

        // print m1
        System.out.println("matrix m1 = ");
        for (int i = 0; i < m1.numRows(); i++) {
            for (int j = 0; j < m1.numCols(); j++) {
                System.out.print(m1.get(i, j));
                if (j != m1.numCols() - 1) System.out.print(" \t");
            }
            System.out.println();
        }
        System.out.println("===========================");

        // create m2
        SparseMatrix m2 = new SparseMatrix(c1, c2);
        for (int i = 0; i < m2.numRows(); i++)
            for (int j = 0; j < m2.numCols(); j++)
                m2.set(i, j, rnd.nextInt(11));

        // print m2
        System.out.println("matrix m2 = ");
        for (int i = 0; i < m2.numRows(); i++) {
            for (int j = 0; j < m2.numCols(); j++) {
                System.out.print(m2.get(i, j));
                if (j != m2.numCols() - 1) System.out.print(" \t");
            }
            System.out.println();
        }
        System.out.println("===========================");

        // create m3
        SparseMatrix m3 = new SparseMatrix(r1, c1);
        for (int i = 0; i < m3.numRows(); i++)
            for (int j = 0; j < m3.numCols(); j++)
                m3.set(i, j, rnd.nextInt(11));

        //print m3
        System.out.println("matrix m3 = ");
        for (int i = 0; i < m3.numRows(); i++) {
            for (int j = 0; j < m3.numCols(); j++) {
                System.out.print(m3.get(i, j));
                if (j != m3.numCols() - 1) System.out.print(" \t");
            }
            System.out.println();
        }
        System.out.println("===========================");

        // print m1 * m2
        Matrix m4 = m1.multiply(m2);
        System.out.println("m1*m2 = ");
        for (int i = 0; i < m4.numRows(); i++) {
            for (int j = 0; j < m4.numCols(); j++) {
                System.out.print(m4.get(i, j));
                if (j != m4.numCols() - 1) System.out.print(" \t");
            }
            System.out.println();
        }
        System.out.println("===========================");

        // print m1 + m3
        Matrix m5 = m1.add(m3);
        System.out.println("m1+m3 = ");
        for (int i = 0; i < m5.numRows(); i++) {
            for (int j = 0; j < m5.numCols(); j++) {
                System.out.print(m5.get(i, j));
                if (j != m5.numCols() - 1) System.out.print(" \t");
            }
            System.out.println();
        }
    }
}
