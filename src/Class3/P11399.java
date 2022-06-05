package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            times[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times);

        int result = 0;
        int prev_time = 0;
        for(int i=0;i<N;i++){
            int time = prev_time + times[i];
            result += time;
            prev_time = time;
        }

        System.out.print(result);
    }
}
