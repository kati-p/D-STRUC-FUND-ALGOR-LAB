package lab;

import datastr.SeparateChainingHashMap;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // read file
        SeparateChainingHashMap enroll = new SeparateChainingHashMap(12);
        try (Scanner reader = new Scanner(new File("src\\lab\\register.csv"))) {
            while (reader.hasNext()) {
                String line = reader.nextLine();
                String[] data = line.split(",",9);
                Student s = new Student(data[0].trim(),data[1].trim(),data[2].trim());
                CourseGrade c = new CourseGrade(data[3].trim(),data[4].trim(),data[5].trim()
                        ,data[6].trim(),data[7].trim(),data[8].trim());
                ArrayList<CourseGrade> cgList;
                if (enroll.containsKey(s)) {
                    cgList = (ArrayList<CourseGrade>) enroll.get(s);
                }
                else {
                    cgList = new ArrayList<>();
                }
                cgList.add(c);
                enroll.put(s, cgList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // print result
        System.out.println(enroll);
    }
}
