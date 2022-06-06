package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11727 {

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        dp[1] = 1;
        if (N > 1) {
            dp[2] = 3;
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
        }

        System.out.print(dp[N]);
    }
}
