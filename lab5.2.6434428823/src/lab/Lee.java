package lab;

import datastr.ArrayQueue;
import datastr.Queue;

public class Lee {
    private static final int SPACE = -1;
    private static final int BLOCK = -9;
    private static int[][] map = new int[10][10];

    private static class Pos {
        int row, col;
        Pos(int r, int c) {
            row = r;
            col = c;
        }
    }

    public static void main(String[] args) {
        for (int i=0; i < map.length; i++)
            for (int j = 0; j < map[i].length; j++)
                map[i][j] = Math.random()<0.2 ? BLOCK : SPACE;
        findPath(new Pos(0,0), new Pos(0,map[0].length-1));
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++)
                System.out.printf("%4d", map[i][j]);
            System.out.println();
        }
    }
    static void findPath(Pos source, Pos target) {
        map[source.row][source.col] = 0;
        map[target.row][target.col] = SPACE;
        Queue q = new ArrayQueue();
        q.enqueue(source);
        while (!q.isEmpty()) {
            Pos p = (Pos) q.dequeue();
            if (p.row == target.row && p.col == target.col) break;
            expand(q, p.row + 1, p.col, map[p.row][p.col]);
            expand(q, p.row - 1, p.col, map[p.row][p.col]);
            expand(q, p.row, p.col + 1, map[p.row][p.col]);
            expand(q, p.row, p.col -1, map[p.row][p.col]);
        }
    }
    static void expand(Queue q, int r, int c, int k) {
        if (r < 0 || r >= map.length ||
                c < 0 || c >= map[r].length ||
                map[r][c] != SPACE) return;
        map[r][c] = k + 1;
        q.enqueue(new Pos(r, c));
    }
}
