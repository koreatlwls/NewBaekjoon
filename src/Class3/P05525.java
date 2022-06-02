package Class3;

import java.io.IOException;
import java.util.Scanner;

public class P05525 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();

        char[] arr = sc.next().toCharArray();
        int[] memo = new int[M];
        int ans = 0;

        for (int i = 1; i < M - 1; i++) {
            if (arr[i] == 'O' && arr[i + 1] == 'I') {
                memo[i + 1] = memo[i - 1] + 1;

                if (memo[i + 1] >= N && arr[i - 2 * N + 1] == 'I')
                    ans++;
            }
        }

        System.out.println(ans);
    }
}