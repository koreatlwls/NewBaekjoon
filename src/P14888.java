import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14888 {

    static int N;
    static int[] inputs;
    static int[] operators = new int[4];
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        inputs = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(inputs[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    static void dfs(int num, int idx) {
        if (idx == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {

                operators[i]--;

                switch (i) {

                    case 0:	dfs(num + inputs[idx], idx + 1);	break;
                    case 1:	dfs(num - inputs[idx], idx + 1);	break;
                    case 2:	dfs(num * inputs[idx], idx + 1);	break;
                    case 3:	dfs(num / inputs[idx], idx + 1);	break;

                }

                operators[i]++;
            }
        }
    }
}
