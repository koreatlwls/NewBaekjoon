import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14889 {

    static int N;
    static int[][] score;
    static boolean[] visited;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        score = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0);

        System.out.println(MIN);
    }

    static void solve(int count, int idx) {
        if (count == N / 2) {
            calculateScore();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                solve(count + 1, i);
                visited[i] = false;
            }
        }
    }

    static void calculateScore() {
        int startScore = 0;
        int linkScore = 0;

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                for (int x = 0; x < N; x++) {
                    if (visited[x]) {
                        startScore += score[i][x];
                    }
                }
            } else {
                for (int y = 0; y < N; y++) {
                    if (!visited[y]) {
                        linkScore += score[i][y];
                    }
                }
            }
        }

        MIN = Math.min(MIN, Math.abs(startScore - linkScore));
    }
}
