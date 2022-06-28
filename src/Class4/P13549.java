package Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P13549 {

    static int N, K;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static int max = 100000;

    static class Node {
        int idx;
        int time;

        public Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[max + 1];
        bfs();
        System.out.println(min);
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            visited[now.idx] = true;
            if (now.idx == K) min = Math.min(min, now.time);

            if (now.idx * 2 <= max && !visited[now.idx * 2]) queue.add(new Node(now.idx * 2, now.time));
            if (now.idx + 1 <= max && !visited[now.idx + 1]) queue.add(new Node(now.idx + 1, now.time + 1));
            if (now.idx - 1 >= 0 && !visited[now.idx - 1]) queue.add(new Node(now.idx - 1, now.time + 1));
        }
    }
}
