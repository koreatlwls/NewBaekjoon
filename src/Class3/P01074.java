package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01074 {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N);

        solve(size, r, c);
        System.out.print(count);
    }

    static void solve(int size, int row, int col) {
        if (size == 1) return;

        if (row < size / 2 && col < size / 2) {
            solve(size / 2, row, col);
        } else if (row < size / 2 && col >= size / 2) {
            count += size * size / 4;
            solve(size / 2, row, col - size / 2);
        } else if (row >= size / 2 && col < size / 2) {
            count += (size * size / 4) * 2;
            solve(size / 2, row - size / 2, col);
        } else {
            count += (size * size / 4) * 3;
            solve(size / 2, row - size / 2, col - size / 2);
        }
    }
}
