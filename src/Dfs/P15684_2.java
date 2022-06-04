package Dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15684_2 {

    static int N, M, H;
    static int[][] map;
    static boolean isFinish = false;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[a][b + 1] = 2;
        }

        for (int i = 0; i <= 3; i++) {
            answer = i;
            dfs(1, 1, 0);
            if (isFinish) break;
        }

        System.out.print((isFinish ? answer : -1));
    }

    static void dfs(int row, int col, int count) {
        if (isFinish) return;
        if (answer == count) {
            if (check()) isFinish = true;
            return;
        }

        for (int i = row; i <= H; i++) {
            for (int j = col; j < N; j++) {
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    map[i][j + 1] = 2;

                    dfs(1, 1, count + 1);

                    map[i][j] = 0;
                    map[i][j + 1] = 0;
                }
            }
        }
    }

    static boolean check() {
        for (int i = 1; i <= N; i++) {
            int nextHeight = 1;
            int nextWidth = i;

            while (nextHeight <= H) {
                if (map[nextHeight][nextWidth] == 1) nextWidth++;
                else if (map[nextHeight][nextWidth] == 2) nextWidth--;
                nextHeight++;
            }
            if (nextWidth != i) return false;
        }
        return true;
    }
}
