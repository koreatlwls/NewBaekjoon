package Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P24444 {

    static int N,M,R;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }
        visited = new boolean[N+1];
        answer = new int[N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i=0;i<=N;i++){
            Collections.sort(list.get(i));
        }
        bfs();

        for(int i=1;i<=N;i++){
            System.out.println(answer[i]);
        }
    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(R);
        visited[R] = true;

        int rank = 1;

        while(!queue.isEmpty()){
            int now = queue.poll();
            answer[now] = rank++;

            for(int num : list.get(now)){
                if(visited[num])continue;

                queue.add(num);
                visited[num] = true;
            }
        }
    }
}
