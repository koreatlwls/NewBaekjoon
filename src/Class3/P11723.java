package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        int bit = 0;
        for (int i = 0; i < M; i++) {
            String[] inputs = br.readLine().split(" ");
            int num;

            if (inputs[0].equals("add")) {
                num = Integer.parseInt(inputs[1]);
                bit |= (1 << (num - 1));
            } else if (inputs[0].equals("remove")) {
                num = Integer.parseInt(inputs[1]);
                bit = bit & ~(1 << (num - 1));
            } else if (inputs[0].equals("check")) {
                num = Integer.parseInt(inputs[1]);
                sb.append((bit & (1 << (num - 1))) != 0 ? "1\n" : "0\n");
            } else if (inputs[0].equals("toggle")) {
                num = Integer.parseInt(inputs[1]);
                bit ^= (1 << (num - 1));
            } else if (inputs[0].equals("all")) {
                bit |= (~0);
            } else {
                bit &= 0;
            }
        }

        System.out.print(sb);
    }
}
