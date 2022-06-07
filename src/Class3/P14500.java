package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14500 {

    static int N, M;
    static int[][] map;
    static int[][] dr = {{0, 0, 0, 0}, {0, 1, 2, 3}, {0, 0, 1, 2}, {0, 0, 1, 2}, {0, 1, 2, 2}, {0, 1, 2, 2}, {0, 1, 1, 1}, {0, 0, 0, -1}, {0, -1, -1, -1}, {0, 0, 0, 1}, {0, 0, 1, 1}, {0, -1, -1, -2}, {0, 1, 1, 2}, {0, 0, -1, -1}, {0, 0, 1, 1}, {0, 0, 0, 1}, {0, 0, 0, -1}, {0, 1, 2, 1}, {0, 1, 2, 1}};
    static int[][] dc = {{0, 1, 2, 3}, {0, 0, 0, 0}, {0, -1, -1, -1}, {0, 1, 1, 1}, {0, 0, 0, 1}, {0, 0, 0, -1}, {0, 0, 1, 2}, {0, 1, 2, 2}, {0, 0, 1, 2}, {0, 1, 2, 2}, {0, 1, 0, 1}, {0, 0, 1, 1}, {0, 0, 1, 1}, {0, 1, 1, 2}, {0, 1, 1, 2}, {0, 1, 2, 1}, {0, 1, 2, 1}, {0, 0, 0, 1}, {0, 0, 0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int x = 0; x <19; x++) {
                    int count = 0;
                    for (int y = 0; y < 4; y++) {
                        int nextRow = i + dr[x][y];
                        int nextCol = j + dc[x][y];

                        if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) {
                            count = 0;
                            break;
                        }

                        count += map[nextRow][nextCol];
                    }
                    max = Math.max(max, count);
                }
            }
        }

        System.out.print(max);
    }
}
