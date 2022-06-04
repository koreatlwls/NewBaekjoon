package Class3;

import java.io.*;
import java.util.*;

public class P10026 {

    static int N;
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] redgreenVisited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class RGB {
        int row;
        int col;
        char rgb;

        public RGB(int row, int col, char rgb) {
            this.row = row;
            this.col = col;
            this.rgb = rgb;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        visited = new boolean[N][N];
        redgreenVisited = new boolean[N][N];

        int count = 0;
        int redgreenCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, map[i][j]);
                    count++;
                }
                if (!redgreenVisited[i][j]) {
                    redgreenBfs(i, j, map[i][j]);
                    redgreenCount++;
                }
            }
        }

        System.out.printf("%d %d", count, redgreenCount);
    }

    static void bfs(int row, int col, char check) {
        Queue<RGB> queue = new LinkedList<>();
        queue.add(new RGB(row, col, check));
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            RGB now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dr[i];
                int nextCol = now.col + dc[i];

                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) continue;
                if (visited[nextRow][nextCol] || map[nextRow][nextCol] != check) continue;

                queue.add(new RGB(nextRow, nextCol, now.rgb));
                visited[nextRow][nextCol] = true;
            }
        }
    }

    static void redgreenBfs(int row, int col, char check) {
        Queue<RGB> queue = new LinkedList<>();
        queue.add(new RGB(row, col, check));
        redgreenVisited[row][col] = true;

        while (!queue.isEmpty()) {
            RGB now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dr[i];
                int nextCol = now.col + dc[i];

                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) continue;
                if (redgreenVisited[nextRow][nextCol]) continue;
                if(check == 'R' || check == 'G'){
                    if(map[nextRow][nextCol] == 'B'){
                        continue;
                    }
                }
                else {
                    if(map[nextRow][nextCol] != check){
                        continue;
                    }
                }

                queue.add(new RGB(nextRow, nextCol, now.rgb));
                redgreenVisited[nextRow][nextCol] = true;
            }
        }
    }

}
