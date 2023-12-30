package lab;

public class Student {

    private String id, fn, ln;
    private double gpax;

    public Student(String id, String fn, String ln, double gpax) {
        this.id = id;
        this.fn = fn;
        this.ln = ln;
        this.gpax = gpax;
    }

    public void setGPAX(double gpax) {
        this.gpax = gpax;
    }

    public String getID() {
        return id;
    }

    public String getFname() {
        return fn;
    }

    public String getLname() {
        return ln;
    }

    public double getGpax() {
        return gpax;
    }

    public boolean equals(Object s) {
        if (s instanceof Student) {
            return id.equals(((Student) s).getID());
        }
        return false;
    }

    public String toString() {
        return id + "," + fn + "," + ln + "," + gpax;
    }
}
