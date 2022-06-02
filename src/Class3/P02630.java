package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P02630 {

    static int N;
    static int[][] paper;
    static int zeroCount = 0;
    static int oneCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(N, 0, 0);

        System.out.println(zeroCount);
        System.out.print(oneCount);
    }

    static void recursion(int size, int row, int col) {
        if (!isPaper(size, row, col)) {
            int newSize = size / 2;

            recursion(newSize, row, col);
            recursion(newSize, row + newSize, col);
            recursion(newSize, row, col + newSize);
            recursion(newSize, row + newSize, col + newSize);
        }
    }

    static boolean isPaper(int size, int row, int col) {
        int color = paper[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != paper[i][j]) {
                    return false;
                }
            }
        }

        if (color == 0) {
            zeroCount++;
        } else {
            oneCount++;
        }
        return true;
    }
}
