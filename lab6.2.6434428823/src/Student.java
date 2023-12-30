public class Student {

    private String id, fn, ln;

    public Student(String id, String fn, String ln) {
        this.id = id;
        this.fn = fn;
        this.ln = ln;
    }

    public String getID() {
        return id;
    }

    public String getFn() {
        return fn;
    }

    public String getLn() {
        return ln;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj instanceof Student) {
            Student s = (Student) obj;
            return this.id.equals(s.getID())
                    && this.fn.equals(getFn())
                    && this.ln.equals(getLn());
        }
        return false;
    }

    public int hashCode() {
        return Integer.valueOf(id);
    }
}
