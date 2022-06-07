package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P16928 {

    static int N, M;
    static boolean[] visited = new boolean[101];
    static Map<Integer, Integer> ladder = new HashMap<>();
    static Map<Integer, Integer> snake = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            ladder.put(x, y);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            snake.put(u, v);
        }

        int result = bfs();
        System.out.print(result);
    }

    static int bfs() {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int x = 0; x < size; x++) {
                int now = queue.poll();

                if(now == 100){
                    return count;
                }

                for (int i = 1; i <= 6; i++) {
                    int next = now + i;

                    if (ladder.containsKey(next)) {
                        next = ladder.get(next);
                    } else if (snake.containsKey(next)) {
                        next = snake.get(next);
                    }

                    if (next < 1 || next > 100) continue;
                    if (visited[next]) continue;

                    queue.add(next);
                    visited[next] = true;
                }
            }

            count++;
        }

        return -1;
    }
}
