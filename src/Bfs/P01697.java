package Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P01697 {

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = bfs(N, K);
        System.out.print(result-1);
    }

    static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited = new boolean[100001];
        visited[start] = true;
        int time = 0;
        boolean isFinish = false;

        while (!queue.isEmpty()) {
            if (isFinish) break;

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int now = queue.poll();

                if (now == end) {
                    isFinish = true;
                    break;
                }

                for (int j = 0; j < 3; j++) {
                    int next = 0;
                    switch (j) {
                        case 0:
                            next = now - 1;
                            break;
                        case 1:
                            next = now + 1;
                            break;
                        case 2:
                            next = now * 2;
                            break;
                    }

                    if (next < 0 || next > 100000 || visited[next]) continue;

                    queue.add(next);
                    visited[next] = true;
                }
            }

            time++;
        }

        return time;
    }
}
