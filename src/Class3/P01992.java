package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01992 {

    static int N;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        recursion(N, 0, 0);
        System.out.print(sb);
    }

    static void recursion(int size, int row, int col) {
        if (!isQuadTree(size, row, col)) {
            int newSize = size / 2;

            sb.append("(");
            recursion(newSize, row, col);
            recursion(newSize, row, col + newSize);
            recursion(newSize, row + newSize, col);
            recursion(newSize, row + newSize, col + newSize);
            sb.append(")");
        }
    }

    static boolean isQuadTree(int size, int row, int col) {
        int check = map[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (check != map[i][j])
                    return false;
            }
        }

        sb.append(check);
        return true;
    }
}
