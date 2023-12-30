package lab;

import datastr.SinglyLinkedList;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList numb = new SinglyLinkedList();
        for (int i = 0; i < 100; i++) {
            numb.add(i);
        }

        // print 0-99
        Object[] arrN = numb.toArray();
        System.out.println("Initial list");
        for (int i = 0; i < arrN.length; i++) {
            if (i == arrN.length - 1) System.out.println(arrN[i]);
            else System.out.print(arrN[i] + ", ");
        }

        //print reverse
        numb.reverse();
        Object[] arrR = numb.toArray();
        System.out.println("Reverse");
        for (int i = 0; i < arrR.length; i++) {
            if (i == arrR.length - 1) System.out.println(arrR[i]);
            else System.out.print(arrR[i] + ", ");
        }

        //print remove i to j
        Random rnd = new Random();
        int ft = rnd.nextInt(0, 100);
        int fn = rnd.nextInt(ft, 100);
        numb.removeRange(ft, fn);
        Object[] arrRR = numb.toArray();
        System.out.println("Remove " + ft + ", " + fn);
        for (int i = 0; i < arrRR.length; i++) {
            if (i == arrRR.length - 1) System.out.println(arrRR[i]);
            else System.out.print(arrRR[i] + ", ");
        }
    }
}