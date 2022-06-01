package Class3;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P02178 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String inputs = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = inputs.charAt(j - 1) - '0';
            }
        }

        int result = bfs();
        System.out.print(result);
    }

    static int bfs() {
        int count = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1, 1));
        visited[1][1] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int x = 0; x < size; x++) {
                Point now = queue.poll();

                if (now.x == N && now.y == M) {
                    return count;
                }

                for (int i = 0; i < 4; i++) {
                    int nextRow = now.x + dr[i];
                    int nextCol = now.y + dc[i];

                    if (nextRow < 1 || nextRow > N || nextCol < 1 || nextCol > M) continue;
                    if (visited[nextRow][nextCol] || map[nextRow][nextCol] == 0) continue;

                    queue.add(new Point(nextRow, nextCol));
                    visited[nextRow][nextCol] = true;
                }
            }

            count++;
        }

        return -1;
    }
}
