package Dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P01520 {

    static int M, N;
    static int[][] map;
    static int[][] dp;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        dp = new int[M][N];

        for(int i=0;i<M;i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = dfs(0, 0);
        System.out.print(result);
    }

    static int dfs(int row, int col) {
        if (row == M - 1 && col == N - 1) return 1;
        if (dp[row][col] != -1) return dp[row][col];

        dp[row][col] = 0;
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dr[i];
            int nextCol = col + dc[i];

            if (nextRow < 0 || nextRow >= M || nextCol < 0 || nextCol >= N) continue;
            if (map[row][col] <= map[nextRow][nextCol]) continue;

            dp[row][col] = dp[row][col] + dfs(nextRow, nextCol);
        }

        return dp[row][col];
    }
}
