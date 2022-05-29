import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P07569 {

    static int N, M, H;
    static int[][][] map;
    static boolean[][][] visited;
    static Queue<Tomato> tomatoQueue = new LinkedList<>();
    static int[] dr = {-1, 1, 0, 0, 0, 0};
    static int[] dc = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};

    static class Tomato {
        int row;
        int col;
        int height;

        public Tomato(int height, int row, int col) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        visited = new boolean[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    map[i][j][k] = tomato;
                    if (tomato == 1) {
                        tomatoQueue.add(new Tomato(i, j, k));
                    }
                }
            }
        }

        int result = bfs();

        if(!check()){
            System.out.print(-1);
        }else{
            System.out.print(result-1);
        }

    }

    static int bfs() {
        int count = 0;
        while (!tomatoQueue.isEmpty()) {
            int size = tomatoQueue.size();
            for (int i = 0; i < size; i++) {
                Tomato now = tomatoQueue.poll();
                visited[now.height][now.row][now.col] = true;

                for (int j = 0; j < 6; j++) {
                    int nextHeight = now.height + dh[j];
                    int nextRow = now.row + dr[j];
                    int nextCol = now.col + dc[j];

                    if (nextHeight < 0 || nextHeight >= H || nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M)
                        continue;
                    if (visited[nextHeight][nextRow][nextCol] || map[nextHeight][nextRow][nextCol] == 1 || map[nextHeight][nextRow][nextCol] == -1)
                        continue;

                    map[nextHeight][nextRow][nextCol] = 1;
                    visited[nextHeight][nextRow][nextCol] = true;
                    tomatoQueue.add(new Tomato(nextHeight, nextRow, nextCol));
                }
            }
            count++;
        }

        return count;
    }

    static boolean check(){
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(map[i][j][k] == 0){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
