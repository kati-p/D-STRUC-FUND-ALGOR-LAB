package lab;

import datastr.DenseVector;
import datastr.SparseVector;
import datastr.Vector;

public class Main {
    public static void main(String[] args) {

        // create v1
        DenseVector v1 = new DenseVector(10);
        v1.set(0, 5.0);
        v1.set(1, 2.0);
        v1.set(2, 9.0);
        v1.set(3, 4.0);
        v1.set(4, 4.0);
        v1.set(5, 1.0);
        v1.set(6, 5.0);
        v1.set(7, 4.0);
        v1.set(8, 1.0);
        v1.set(9, 0.0);

        // v1
        System.out.print("v1     = [ ");
        for (int i = 0; i < v1.length(); i++)
            System.out.print(v1.get(i) + " ");
        System.out.println(" ]");

        // 0.5*v1
        DenseVector halfv1 = v1.multiply(0.5);
        System.out.print("0.5*v1 = [ ");
        for (int i = 0; i < v1.length(); i++)
            System.out.print(halfv1.get(i) + " ");
        System.out.println(" ]");

        // create v2
        SparseVector v2 = new SparseVector(10);
        v2.set(0, 1.0);
        v2.set(4, 9.0);
        v2.set(5, 6.0);
        v2.set(6, 5.0);
        v2.set(9, 9.0);

        // v2
        System.out.print("v2     = [ ");
        for (int i = 0; i < v1.length(); i++)
            System.out.print(v2.get(i) + " ");
        System.out.println(" ]");

        // 0.5*v2
        SparseVector halfv2 = v2.multiply(0.5);
        System.out.print("0.5*v2 = [ ");
        for (int i = 0; i < v2.length(); i++)
            System.out.print(halfv2.get(i) + " ");
        System.out.println(" ]");

        // v2 + v1
        Vector v2pv1 = v2.add(v1);
        System.out.print("v2+v1  = [ ");
        for (int i = 0; i < v2pv1.length(); i++)
            System.out.print(v2pv1.get(i) + " ");
        System.out.println(" ]");

        // v1 - v2
        Vector v1mv2 = v1.subtract((Vector) v2);
        System.out.print("v1-v2  = [ ");
        for (int i = 0; i < v1mv2.length(); i++)
            System.out.print(v1mv2.get(i) + " ");
        System.out.println(" ]");

        // v1 . v2
        System.out.println("v1.v2  =  " + v1.dot((Vector) v2));

        // v2 . v1
        System.out.println("v2.v1  =  " + v2.dot((Vector) v1));
    }
}