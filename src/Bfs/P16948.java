package Bfs;

import java.awt.*;
import java.io.*;
import java.util.*;

public class P16948 {

    static int N, r1, c1, r2, c2;
    static boolean[][] visited;
    static int[] dr = {-2, -2, 0, 0, 2, 2};
    static int[] dc = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        int result = bfs();
        System.out.print(result);
    }

    static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(r1, c1));
        visited[r1][c1] = true;
        int count =0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int x =0; x<size;x++) {
                Point now = queue.poll();

                if (now.x == r2 && now.y == c2) return count;

                for (int i = 0; i < 6; i++) {
                    int nextRow = now.x + dr[i];
                    int nextCol = now.y + dc[i];

                    if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) continue;
                    if (visited[nextRow][nextCol]) continue;

                    queue.add(new Point(nextRow, nextCol));
                    visited[nextRow][nextCol] = true;
                }
            }
            count++;
        }

        return -1;
    }
}
