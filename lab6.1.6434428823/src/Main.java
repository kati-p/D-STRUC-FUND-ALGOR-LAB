import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        int cap = rnd.nextInt(5, 11);
        // adjacency matrix 1
        int[][] adjM = new int[cap][cap];
        for (int i = 0; i < adjM.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                int weight = rnd.nextInt(6);    // random weight 1-5 and 0 to nothing
                adjM[i][j] = weight;
                if (i != j) adjM[j][i] = weight;    // edge reverse
            }
        }
        // print adjacency matrix 1
        System.out.println("Random adjacency matrix of graph 1");
        for (int i = 0; i < adjM.length; i++) {
            for (int j = 0; j < adjM[i].length; j++) {
                System.out.print(adjM[i][j]);
                if (j < adjM[i].length - 1) System.out.print("\t");
            }
            System.out.println();
        }
        System.out.println("-----------------");
        // create graph 1
        Graph g1 = new Graph(adjM);
        // print g1
        int[][] g1_adjM = g1.toMatrix();
        System.out.println("Adjacency matrix created from graph 1");
        for (int i = 0; i < g1_adjM.length; i++) {
            for (int j = 0; j < g1_adjM[i].length; j++) {
                System.out.print(g1_adjM[i][j]);
                if (j < g1_adjM[i].length - 1) System.out.print("\t");
            }
            System.out.println();
        }
        System.out.println("-----------------");
        // create graph 2
        Graph g2 = new Graph(cap, cap * cap / 4);
        // print g2
        int[][] g2_adjM = g2.toMatrix();
        System.out.println("Adjacency matrix created from graph 2");
        for (int i = 0; i < g2_adjM.length; i++) {
            for (int j = 0; j < g2_adjM[i].length; j++) {
                System.out.print(g2_adjM[i][j]);
                if (j < g2_adjM[i].length - 1) System.out.print("\t");
            }
            System.out.println();
        }
        System.out.println("-----------------");
    }
}
