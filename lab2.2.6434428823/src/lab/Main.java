package lab;

import datastr.LinkedCollection;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // read student.csv and remove duplicate.
        LinkedCollection lkS = new LinkedCollection();
        try (Scanner reader = new Scanner(new File("src\\lab\\student.csv"))) {
            while (reader.hasNextLine()) {
                String[] stu = reader.nextLine().split(",");
                String id = stu[0];
                String fn = stu[1];
                String ln = stu[2];
                Double gpax = Double.valueOf(stu[3]);
                lkS.add(new Student(id, fn, ln, gpax));
            }
        } catch (Exception e) {
            System.out.println("File not found.");
        }

        if (lkS.containsDup()) {
            lkS.removeDup();
            System.out.println("Duplicate students in file. Removed.");
        } else {
            System.out.println("No duplicate student.");
        }

        // read withdraw.csv and remove duplicate.
        LinkedCollection lkW = new LinkedCollection();
        try (Scanner reader = new Scanner(new File("src\\lab\\withdraw.csv"))) {
            while (reader.hasNextLine()) {
                String[] stu = reader.nextLine().split(",");
                String id = stu[0];
                String fn = stu[1];
                String ln = stu[2];
                Double gpax = Double.valueOf(stu[3]);
                lkW.add(new Student(id, fn, ln, gpax));
            }
        } catch (Exception e) {
            System.out.println("File not found.");
        }
        if (lkW.containsDup()) {
            lkW.removeDup();
            System.out.println("Duplicate withdraws in file. Removed.");
        } else {
            System.out.println("No duplicate withdraw.");
        }
        System.out.println();

        // check equal and print it.
        if (lkS.equals(lkW)) {
            Object[] arrW = lkW.toArray();
            System.out.println("All Withdrew (" + arrW.length + ")");
            for (Object w : arrW) {
                System.out.println(w);
            }
        } else {
            Object[] arrW = lkW.toArray();
            for (Object w : arrW) {
                lkS.removeAll(w);
            }
            Object[] arrS = lkS.toArray();
            System.out.println("All registered (" + arrS.length + ")");
            for (int i = arrS.length - 1; i >= 0; i--) {
                System.out.println(arrS[i]);
            }
            System.out.println();
            System.out.println("All Withdrew (" + arrW.length + ")");
            for (int i = arrW.length - 1; i >= 0; i--) {
                System.out.println(arrW[i]);
            }
        }
    }
}
