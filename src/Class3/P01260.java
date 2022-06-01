package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P01260 {

    static int N, M, V;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 0; i <=N; i++) {
            Collections.sort(list.get(i));
        }

        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");
        bfs();

        System.out.print(sb);
    }

    static void dfs(int num) {
        visited[num] = true;
        sb.append(num + " ");

        for (int node : list.get(num)) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visited = new boolean[N + 1];
        visited[V] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now + " ");

            for (int i = 0; i < list.get(now).size(); i++) {
                int next = list.get(now).get(i);

                if (visited[next]) continue;

                queue.add(next);
                visited[next] = true;
            }
        }
    }
}
