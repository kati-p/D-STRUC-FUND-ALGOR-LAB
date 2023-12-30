package lab;

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
        System.out.println("adjacency matrix");
        for (int i = 0; i < adjM.length; i++) {
            for (int j = 0; j < adjM[i].length; j++) {
                System.out.print(adjM[i][j]);
                if (j < adjM[i].length - 1) System.out.print("\t");
            }
            System.out.println();
        }
        // create graph 1
        Graph g1 = new Graph(adjM);
        // print hash table
        System.out.println("Hash table of edges");
        System.out.println(g1.getGraph().toString());
    }
}
