package Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01149 {

    static int N;
    static int[][] RGB;
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        RGB = new int[N + 1][3];
        DP = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                RGB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DP[1][0] = RGB[1][0];
        DP[1][1] = RGB[1][1];
        DP[1][2] = RGB[1][2];

        for (int i = 2; i <= N; i++) {
            DP[i][0] = RGB[i][0] + Math.min(DP[i-1][1], DP[i-1][2]);
            DP[i][1] = RGB[i][1] + Math.min(DP[i-1][0], DP[i-1][2]);
            DP[i][2] = RGB[i][2] + Math.min(DP[i-1][0], DP[i-1][1]);
        }

        int result = Math.min(DP[N][0], Math.min(DP[N][1], DP[N][2]));
        System.out.print(result);
    }
}
