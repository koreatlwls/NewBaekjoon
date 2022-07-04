package Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P12865 {

    static int N,K;
    static int[][] dp;
    static List<Item> itemList = new ArrayList<>();

    static class Item{
        int W;
        int V;

        public Item(int W, int V){
            this.W = W;
            this.V = V;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N+1][K+1];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            itemList.add(new Item(a,b));
        }

        int max = 0;
        for(int i=1;i <=N;i++){
            for(int j=1;j<=K;j++){
                if(itemList.get(i-1).W <= j){
                    dp[i][j] = Math.max(itemList.get(i-1).V + dp[i-1][j-itemList.get(i-1).W], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
                max = Math.max(dp[i][j], max);
            }
        }

        System.out.print(max);
    }
}
