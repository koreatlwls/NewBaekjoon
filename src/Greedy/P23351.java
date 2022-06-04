package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P23351 {

    static int N, K, A, B;
    static int[] flower;
    static int day = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        flower = new int[N];
        Arrays.fill(flower, K);

        solve();
    }

    static void solve(){
      int index = 0;
      while(true){
          for(int i=index; i<index+A;i++)flower[i%N] +=B;
          for(int i=0;i<N;i++){
              if(--flower[i] ==0){
                  System.out.print(day);
                  return;
              }
          }
          day++;
          index = (index+A)%N;
      }
    }
}
