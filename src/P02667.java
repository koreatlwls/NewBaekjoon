import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class P02667 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> answer = new ArrayList<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer.size());
        Collections.sort(answer);
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }

    static void bfs(int row, int col) {
        int count = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(row, col));
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = now.x + dr[i];
                int nextCol = now.y + dc[i];

                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) continue;
                if (visited[nextRow][nextCol] || map[nextRow][nextCol] == 0) continue;

                queue.add(new Point(nextRow, nextCol));
                visited[nextRow][nextCol] = true;
                count++;
            }
        }

        answer.add(count);
    }
}
