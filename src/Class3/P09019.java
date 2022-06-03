package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P09019 {

    static class DSLR {
        int num;
        String command;

        public DSLR(int num, String command) {
            this.num = num;
            this.command = command;
        }
    }

    static int start, end;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            visited = new boolean[10000];

            String result = bfs();
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    static String bfs() {
        Queue<DSLR> queue = new LinkedList<>();
        queue.add(new DSLR(start, ""));
        visited[start] = true;

        while (!queue.isEmpty()) {
            DSLR now = queue.poll();

            if (now.num == end) {
                return now.command;
            }

            int next;
            for (int i = 0; i < 4; i++) {
                if (i == 0) {
                    next = now.num * 2 % 10000;
                    if (!visited[next]) {
                        queue.add(new DSLR(next, now.command + "D"));
                        visited[next] = true;
                    }
                } else if (i == 1) {
                    next = now.num == 0 ? 9999 : now.num - 1;
                    if (!visited[next]) {
                        queue.add(new DSLR(next, now.command + "S"));
                        visited[next] = true;
                    }
                } else if (i == 2) {
                    next = now.num % 1000 * 10 + now.num / 1000;
                    if (!visited[next]) {
                        queue.add(new DSLR(next, now.command + "L"));
                        visited[next] = true;
                    }
                } else {
                    next = now.num % 10 * 1000 + now.num / 10;
                    if (!visited[next]) {
                        queue.add(new DSLR(next, now.command + "R"));
                        visited[next] = true;
                    }
                }
            }
        }
        return "";
    }
}
