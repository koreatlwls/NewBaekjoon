import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P13700 {

    static int N, S, D, F, B, K;
    static boolean[] visited;
    static boolean[] isPolice;
    static int[] move = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        isPolice = new boolean[N + 1];
        move[0] = F;
        move[1] = -B;

        if (K > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                int police = Integer.parseInt(st.nextToken());
                isPolice[police] = true;
            }
        }

        int result = bfs();
        System.out.print(result != -1 ? result : "BUG FOUND");
    }

    static int bfs() {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        visited[S] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int now = queue.poll();

                if (now == D) return count;

                for (int j = 0; j < 2; j++) {
                    int next = now + move[j];

                    if (next <= 0 || next > N) continue;
                    if (visited[next] || isPolice[next]) continue;

                    queue.add(next);
                    visited[next] = true;
                }
            }

            count++;
        }

        return -1;
    }
}
