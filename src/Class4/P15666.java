package Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P15666 {

    static int N, M;
    static int[] arr;
    static int[] inputs;
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        inputs = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputs);

        dfs(0, 0);
        System.out.print(sb);
    }

    static void dfs(int at, int depth) {
        if (depth == M) {
            StringBuilder sb2 = new StringBuilder();
            for (int val : arr) {
                sb2.append(val).append(" ");
            }
            if (!set.contains(sb2.toString())) {
                sb.append(sb2).append("\n");
                set.add(sb2.toString());
            }
            return;
        }

        for (int i = at; i < N; i++) {
            arr[depth] = inputs[i];
            dfs(i, depth + 1);
        }
    }
}
