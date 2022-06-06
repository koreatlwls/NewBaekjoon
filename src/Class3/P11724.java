package Class3;

import java.util.*;

public class P11724 {

    static int N;
    static int M;
    static int count;
    static int graph[][];
    static boolean visit[];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        graph = new int[N+1][N+1];
        visit = new boolean[N+1];

        for(int i=1; i<=M; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph[a][b] = graph[b][a] = 1;
        }

        for(int i=1; i<=N; i++) {
            if(!visit[i]) {
                bfs(i);
                count ++;
            }
        }
        System.out.println(count);
        scan.close();
    }

    static void bfs(int i) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(i);
        visit[i] = true;

        while(!q.isEmpty()) {
            int temp = q.poll();
            for(int j=1; j<=N; j++) {
                if(graph[temp][j] == 1 && visit[j] == false) {
                    q.offer(j);
                    visit[j] = true;
                }
            }
        }
    }
}
