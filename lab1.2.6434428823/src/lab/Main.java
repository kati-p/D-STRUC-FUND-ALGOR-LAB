package lab;

import datastr.ArraySet;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArraySet clt = new ArraySet(2);
        try (Scanner reader = new Scanner(new File("src\\lab\\student.csv"))) {
            while (reader.hasNextLine()) {
                String[] stu = reader.nextLine().split(",");
                String id = stu[0];
                String fn = stu[1];
                String ln = stu[2];
                Double gpax = Double.valueOf(stu[3]);
                clt.add(new Student(id, fn, ln, gpax));
            }
        } catch (Exception e) {
            System.out.println("File not found.");
        }

        Scanner kb = new Scanner(System.in);
        System.out.println("add or delete or stop?");
        String inp = kb.nextLine();
        while (!inp.equals("stop")) {
            if (inp.equals("add")) {
                String[] stu = kb.nextLine().split("\\s+");
                String id = stu[0].trim();
                String fn = stu[1].trim();
                String ln = stu[2].trim();
                double gpax = Double.parseDouble(stu[3].trim());
                Student s = new Student(id, fn, ln, gpax);
                if (clt.contains(s)) {
                    clt.remove(s);
                    clt.add(s);
                    System.out.println("Change a record.");
                } else {
                    clt.add(s);
                    System.out.println("Add new record.");
                }
            } else if (inp.equals("delete")) {
                String id = kb.nextLine();
                Student s = new Student(id, "", "", 0);
                clt.remove(s);
                System.out.println("Remove a record.");
            } else {
                System.out.println("Invalid command.");
            }
            System.out.println("add or delete or stop?");
            inp = kb.nextLine();
        }

        System.out.println("written to studentNew.csv");
        try (PrintWriter output = new PrintWriter("src\\lab\\studentNew.csv")) {
            Object[] arr = clt.toArray();
            for (int i = 0; i < arr.length; i++) {
                output.println(((Student) arr[i]));
            }
        } catch (Exception e) {
            System.out.println("File can't write.");
        }
    }
}
