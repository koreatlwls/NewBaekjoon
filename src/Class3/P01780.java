package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01780 {

    static int N;
    static int[][] map;
    static int GRAY = 0;
    static int WHITE = 0;
    static int BLACK = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        System.out.println(GRAY);
        System.out.println(WHITE);
        System.out.println(BLACK);
    }

    static void partition(int row, int col, int size) {
        if (colorCheck(row, col, size)) {
            if (map[row][col] == -1) {
                GRAY++;
            } else if (map[row][col] == 0) {
                WHITE++;
            } else {
                BLACK++;
            }

            return;
        }

        int newSize = size / 3;

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row, col + 2 * newSize, newSize);

        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
        partition(row + newSize, col + 2 * newSize, newSize);

        partition(row + 2*newSize, col, newSize);
        partition(row + 2*newSize, col + newSize, newSize);
        partition(row + 2*newSize, col + 2 * newSize, newSize);
    }

    static boolean colorCheck(int row, int col, int size){
        int color = map[row][col];

        for(int i=row;i<row+size;i++){
            for(int j=col;j<col+size;j++){
                if(color != map[i][j]){
                    return false;
                }
            }
        }

        return true;
    }
}
