package lab;

import java.util.Objects;

public class CourseGrade {

    private String id, name, sem, year, credit, grade;

    public CourseGrade(String id, String name, String sem, String year, String credit, String grade) {
        this.id = id;
        this.name = name;
        this.sem = sem;
        this.year = year;
        this.credit = credit;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getSem() {
        return sem;
    }

    public String getYear() {
        return year;
    }

    public String getCredit() {
        return credit;
    }

    public String getGrade() {
        return grade;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if(obj instanceof CourseGrade) {
            CourseGrade cg = (CourseGrade) obj;
            return this.id.equals(cg.getId()) && this.sem.equals(cg.getSem())
                    && this.name.equals(cg.getName())
                    && this.year.equals(cg.getYear())
                    && this.credit.equals(cg.getCredit())
                    && this.grade.equals(cg.getGrade());
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(id,name,year,credit,grade);
    }

    public String toString() {
        return id + "\t" + name + "\t" + year + "/" + sem + "\t" + credit + "\t" + grade;
    }
}
