package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P16236 {

    static int N;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int[] cur = null;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    cur = new int[]{i, j};
                    map[i][j] = 0;
                }
            }
        }

        int size = 2;
        int eat = 0;
        int move = 0;

        while (true) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->
                    o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]))
            );

            boolean[][] visited = new boolean[N][N];

            pq.add(new int[]{cur[0], cur[1], 0});
            visited[cur[0]][cur[1]] = true;

            boolean ck = false;

            while (!pq.isEmpty()) {
                cur = pq.poll();

                if (map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] < size) {
                    map[cur[0]][cur[1]] = 0;
                    eat++;
                    move += cur[2];
                    ck = true;
                    break;
                }

                for (int k = 0; k < 4; k++) {
                    int nextRow = cur[0] + dr[k];
                    int nextCol = cur[1] + dc[k];

                    if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) continue;
                    if (visited[nextRow][nextCol] || map[nextRow][nextCol] > size) continue;

                    pq.add(new int[]{nextRow, nextCol, cur[2] + 1});
                    visited[nextRow][nextCol] = true;
                }
            }

            if (!ck)
                break;

            if (size == eat) {
                size++;
                eat = 0;
            }
        }

        System.out.print(move);
    }
}
