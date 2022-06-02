package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P02606 {

    static int N, M;
    static int[][] computer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        computer = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computer[a][b] = 1;
            computer[b][a] = 1;
        }

        int result = bfs();
        System.out.print(result);
    }

    static int bfs() {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int i=1;i<=N;i++){
                if(now == i) continue;
                if(visited[i] || computer[now][i] == 0)continue;

                queue.add(i);
                visited[i] = true;
                count++;
            }
        }

        return count;
    }
}
