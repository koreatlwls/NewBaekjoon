import java.io.*;
import java.util.*;

public class P01012 {

    static int M,N,K;
    static int[][] map;
    static boolean[][] visited;
    static int answer;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static class Cabbage{
        int row;
        int col;

        public Cabbage(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }

            answer = 0;

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(!visited[i][j] && map[i][j] == 1){
                        answer++;
                        bfs(i,j);
                    }
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }

    static void bfs(int row, int col){
        Queue<Cabbage> queue = new LinkedList<>();
        queue.add(new Cabbage(row, col));
        visited[row][col] = true;

        while(!queue.isEmpty()){
            Cabbage now = queue.poll();

            for(int i=0;i<4;i++){
                int nextRow = now.row + dr[i];
                int nextCol = now.col + dc[i];

                if(nextRow <0 || nextRow >=N || nextCol <0 || nextCol >=M)continue;
                if(visited[nextRow][nextCol] || map[nextRow][nextCol] == 0)continue;

                queue.add(new Cabbage(nextRow, nextCol));
                visited[nextRow][nextCol] = true;
            }
        }
    }
}
