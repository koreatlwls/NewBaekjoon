import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01003 {

    static int[][] fibonacci = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        fibonacci[0][0] = 1;
        fibonacci[0][1] = 0;
        fibonacci[1][0] = 0;
        fibonacci[1][1] = 1;

        for(int i=2;i<=40;i++){
            fibonacci[i][0] = fibonacci[i-1][0] + fibonacci[i-2][0];
            fibonacci[i][1] = fibonacci[i-1][1] + fibonacci[i-2][1];
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            sb.append(fibonacci[N][0] + " " + fibonacci[N][1]).append("\n");
        }

        System.out.print(sb);
    }
}
