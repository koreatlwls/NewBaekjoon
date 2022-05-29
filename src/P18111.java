import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P18111 {

    static int N, M, B;
    static int[][] board;
    static int MAX_BOARD = Integer.MIN_VALUE;
    static int MIN_BOARD = Integer.MAX_VALUE;
    static int ANS_TIME = Integer.MAX_VALUE;
    static int ANS_HEIGHT = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                MAX_BOARD = Math.max(MAX_BOARD, board[i][j]);
                MIN_BOARD = Math.min(MIN_BOARD, board[i][j]);
            }
        }

        solve();

        System.out.println(ANS_TIME + " " + ANS_HEIGHT);
    }

    static void solve() {
        for (int i = MIN_BOARD; i <= MAX_BOARD; i++) {
            int inventory = B;
            int sum_time = 0;

            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    int dif = board[x][y] - i;

                    if (dif > 0) {
                        sum_time += Math.abs(dif) * 2;
                        inventory += Math.abs(dif);
                    } else if (dif < 0) {
                        sum_time += Math.abs(dif);
                        inventory -= Math.abs(dif);
                    }
                }
            }

            if (inventory < 0)
                continue;
            if (ANS_TIME >= sum_time) {
                ANS_TIME = sum_time;
                ANS_HEIGHT = i;
            }
        }
    }
}
