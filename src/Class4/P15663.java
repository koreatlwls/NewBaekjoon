package Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P15663 {

    static int N, M;
    static int[] arr;
    static int[] inputs;
    static boolean[] visited;
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        inputs = new int[N + 1];
        visited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputs);

        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int depth) {
        if (depth == M) {
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb2.append(arr[i]).append(" ");
            }
            if (!set.contains(sb2.toString())) {
                sb.append(sb2.toString()).append("\n");
                set.add(sb2.toString());
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                arr[depth] = inputs[i];
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
