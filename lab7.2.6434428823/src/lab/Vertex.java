package lab;

import java.util.Objects;

public class Vertex {
    private int name;

    public Vertex(int name) {
        this.name = name;
    }

    public int getName() {
        return name;
    }

    public String toString() {
        return "" + name;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj instanceof Vertex) {
            return this.name == ((Vertex) obj).getName();
        }
        return false;
    }

    public int hashCode() {
        return name * 13;
    }

}
