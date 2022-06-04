package Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P05014 {

    static int F,S,G,U,D;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F+1];

        int result = bfs();
        System.out.print(result == -1 ? "use the stairs" : result);
    }

    static int bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        visited[S] = true;
        int count = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0;i<size;i++){
                int now = queue.poll();

                if(now == G)return count;

                int nextUp = now + U;
                int nextDown = now - D;

                if(nextUp >=1 && nextUp <= F){
                    if(!visited[nextUp]){
                        queue.add(nextUp);
                        visited[nextUp] = true;
                    }
                }

                if(nextDown >=1 && nextDown <= F){
                    if(!visited[nextDown]){
                        queue.add(nextDown);
                        visited[nextDown] = true;
                    }
                }
            }

            count ++;
        }

        return -1;
    }
}
