import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P14502 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static List<Virus> virusList = new ArrayList<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int MAX = Integer.MIN_VALUE;

    static class Virus {
        int row;
        int col;

        public Virus(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virusList.add(new Virus(i, j));
                }
            }
        }

        dfs(0);
        System.out.print(MAX);
    }

    static void dfs(int count) {
        if (count == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        visited = new boolean[N][M];
        Queue<Virus> queue = new LinkedList<>();

        for (int i = 0; i < virusList.size(); i++) {
            int row = virusList.get(i).row;
            int col = virusList.get(i).col;

            visited[row][col] = true;
            queue.add(new Virus(row, col));
        }

        while (!queue.isEmpty()) {
            Virus now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dr[i];
                int nextCol = now.col + dc[i];

                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) continue;
                if (visited[nextRow][nextCol] || map[nextRow][nextCol] == 1) continue;

                queue.add(new Virus(nextRow, nextCol));
                visited[nextRow][nextCol] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) count++;
            }
        }

        MAX = Math.max(MAX, count);
    }
}
