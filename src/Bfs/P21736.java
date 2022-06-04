package Bfs;

import java.awt.*;
import java.io.*;
import java.util.*;

public class P21736 {

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int startRow, startCol;
    static int answer = 0;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'I') {
                    startRow = i;
                    startCol = j;
                    map[i][j] = 'O';
                }
            }
        }

        bfs();
        System.out.print(answer == 0 ? "TT" : answer);
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startRow, startCol));
        visited[startRow][startCol] = true;

        while(!queue.isEmpty()){
            Point now = queue.poll();

            for(int i=0;i<4;i++){
                int nextRow = now.x+dr[i];
                int nextCol = now.y + dc[i];

                if(nextRow <0 || nextRow >=N || nextCol <0 || nextCol >=M)continue;
                if(visited[nextRow][nextCol] || map[nextRow][nextCol] == 'X')continue;
                if(map[nextRow][nextCol] == 'P')answer++;

                queue.add(new Point(nextRow,nextCol));
                visited[nextRow][nextCol] = true;
            }
        }
    }
}
