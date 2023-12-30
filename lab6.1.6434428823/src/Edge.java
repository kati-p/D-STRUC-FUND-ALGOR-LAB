public class Edge {
    private Vertex st, end;

    public Edge(Vertex b, Vertex e) {
        st = b;
        end = e;
    }

    public int getSource() {
        return st.getName();
    }

    public int getDest() {
        return end.getName();
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj instanceof Edge) {
            Edge edge = (Edge) obj;
            return (this.st.equals(edge.st) && this.end.equals(edge.end));
        }
        return false;
    }

    public int hashCode() {
        return (st.hashCode() * 7) + (end.hashCode() * 31);
    }
}
