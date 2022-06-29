package Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11053 {

    static int N;
    static int[] input;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        input = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        int LIS = 0;
        for(int i=0;i<N;i++){
            int idx = BinarySearch(input[i], 0, LIS, LIS+1);

            if(idx == -1){
                dp[LIS++] = input[i];
            }else{
                dp[idx] = input[i];
            }
        }

        System.out.print(LIS);
    }

    static int BinarySearch(int num, int start, int end, int size){
        int res = 0;
        while(start<=end){
            int mid = (start + end) / 2;

            if(num <= dp[mid]){
                res = mid;
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }

        if(start == size){
            return -1;
        }else{
            return res;
        }
    }
}
