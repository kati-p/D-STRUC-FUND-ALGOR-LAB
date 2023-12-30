import java.util.HashMap;
import java.util.Random;

public class Graph {

    private HashMap<Edge, Integer> graph = new HashMap<Edge, Integer>();
    private Vertex[] vertexes;
    private Edge[] edges;

    public HashMap getGraph() {
        return graph;
    }

    public Graph(int capV, int capEd) {
        // check capacity's edges
        int maxCapEd = ((capV * (capV - 1)) / 2) + capV;
        if (capEd > maxCapEd) throw new IllegalArgumentException("Edges' size over");
        // create size of array for vertex and graph
        this.vertexes = new Vertex[capV];
        this.edges = new Edge[capEd];
        Random rnd = new Random();
        // create vertexes
        for (int i = 0; i < vertexes.length; i++) vertexes[i] = new Vertex(i);
        // create edges
        for (int i = 0; i < edges.length; i++) {
            // random edge and if edge contains in edges, random again
            boolean contain = false;
            Vertex st = vertexes[rnd.nextInt(vertexes.length)];
            Vertex end = vertexes[rnd.nextInt(st.getName() + 1)];
            Edge edge = new Edge(st, end);
            for (int j = 0; j < i; j++) {
                if (edges[j].equals(edge)) contain = true;
            }
            while (contain) {
                contain = false;
                st = vertexes[rnd.nextInt(vertexes.length)];
                end = vertexes[rnd.nextInt(st.getName() + 1)];
                edge = new Edge(st, end);
                for (int j = 0; j < i; j++) {
                    if (edges[j].equals(edge)) contain = true;
                }
            }
            // add in edges
            edges[i] = edge;
            // add in hashMap
            graph.put(edges[i], rnd.nextInt(1, 5)); // random weight 1-4
        }
    }

    public Graph(int[][] adjM) {
        // create vertexes
        vertexes = new Vertex[adjM.length];
        for (int i = 0; i < vertexes.length; i++) vertexes[i] = new Vertex(i);
        // create ed's size
        int n = 0;
        for (int i = 0; i < adjM.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (adjM[i][j] != 0) {
                    n++;
                }
            }
        }
        edges = new Edge[n];
        // create and put edge in edges and hashMap
        n = 0;
        for (int i = 0; i < adjM.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (adjM[i][j] != 0) {
                    Edge edge = new Edge(new Vertex(i), new Vertex(j));
                    edges[n] = edge;
                    graph.put(edge, adjM[i][j]);
                    n++;
                }
            }
        }
    }

    public int weight(Edge e) {
        Edge eR = new Edge(new Vertex(e.getDest()), new Vertex(e.getSource()));
        if (graph.containsKey(e)) return graph.get(e);
        if (graph.containsKey(eR)) return graph.get(eR);
        return 0;
    }

    public int[][] toMatrix() {
        int[][] m = new int[vertexes.length][vertexes.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                Edge edge = new Edge(new Vertex(i), new Vertex(j));
                if (graph.containsKey(edge)) {
                    int weight = graph.get(edge);
                    m[i][j] = weight;
                    if (i != j) m[j][i] = weight;   // edge reverse
                }
            }
        }
        return m;
    }
}
