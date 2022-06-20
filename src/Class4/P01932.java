package Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01932 {

    static int N;
    static int[][] input;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        input = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
                if (i == 1) {
                    dp[i][j] = input[i][j];
                } else {
                    if (j == 1) {
                        dp[i][j] = input[i][j] + dp[i - 1][j];
                    } else if (j == i) {
                        dp[i][j] = input[i][j] + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = input[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                    }
                }
            }
        }

        int max = 0;
        for(int i=1;i<=N;i++){
            max = Math.max(max, dp[N][i]);
        }
        System.out.print(max);
    }
}
