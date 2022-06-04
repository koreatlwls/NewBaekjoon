package Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P02644 {

    static int N, M;
    static int countA, countB;
    static int[][] map;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        dist = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        countA = Integer.parseInt(st.nextToken());
        countB = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;
        }

        bfs();
        if(dist[countB]== 0){
            System.out.print(-1);
        }else{
            System.out.print(dist[countB]);
        }
    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(countA);

        while(!queue.isEmpty()){
            int now = queue.poll();

            if(now == countB){
                break;
            }

            for(int i=1;i<=N;i++){
                if(map[now][i] == 1 && dist[i] ==0){
                    dist[i] = dist[now] +1;
                    queue.add(i);
                }
            }
        }
    }
}
