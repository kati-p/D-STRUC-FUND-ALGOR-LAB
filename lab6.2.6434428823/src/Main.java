import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // read file
        HashMap<Student, ArrayList<CourseGrade>> enroll = new HashMap<>();
        try (Scanner reader = new Scanner(new File("src\\register.csv"))) {
            while (reader.hasNext()) {
                String line = reader.nextLine();
                String[] data = line.split(",",9);
                Student s = new Student(data[0].trim(),data[1].trim(),data[2].trim());
                CourseGrade c = new CourseGrade(data[3].trim(),data[4].trim(),data[5].trim()
                        ,data[6].trim(),data[7].trim(),data[8].trim());
                ArrayList<CourseGrade> cgList;
                if (enroll.containsKey(s)) {
                    cgList = enroll.get(s);
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
        Scanner input = new Scanner(System.in);
        System.out.println("Enter student ID");
        String id = input.nextLine().trim();
        Student s = new Student(id,"","");
        if (enroll.containsKey(s)){
            ArrayList<CourseGrade> cg = enroll.get(s);
            for (CourseGrade c : cg) System.out.println(c);
        } else {
            System.out.println("invalid id");
        }
    }
}
