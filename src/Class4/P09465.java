package Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P09465 {

    static int N;
    static int[][] data;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            N = Integer.parseInt(br.readLine());

            data = new int[2][N];
            dp = new int[2][N];

            for(int i=0;i<2;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = data[0][0];
            dp[1][0] = data[1][0];

            if(N>=2){
                dp[0][1] = data[0][1] + data[1][0];
                dp[1][1] = data[1][1] + data[0][0];
            }

            for(int i =2;i<N;i++){
                dp[0][i] = data[0][i] + Math.max(dp[1][i-1], Math.max(dp[0][i-2], dp[1][i-2]));
                dp[1][i] = data[1][i] + Math.max(dp[0][i-1], Math.max(dp[0][i-2], dp[1][i-2]));
            }

            int result = Math.max(dp[0][N-1], dp[1][N-1]);
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
