package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P02436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        long gcd = Long.parseLong(st.nextToken());
        long lcm = Long.parseLong(st.nextToken());
        long x = gcd;
        long y = lcm;

        long xy = gcd * lcm;

        for (long i = 2 * gcd; i * i <= xy; i += gcd) {
            if (xy % i == 0) {
                long tmp = xy / i;

                if (gcd(i, tmp) == gcd) {
                    if (x + y > i + tmp) {
                        x = i;
                        y = tmp;
                    }
                }
            }
        }

        System.out.print(x + " " + y);
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
