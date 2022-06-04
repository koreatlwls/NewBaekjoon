package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P09375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                String[] inputs = br.readLine().split(" ");
                map.put(inputs[1], map.getOrDefault(inputs[1], 0) + 1);
            }

            int result = 1;

            for (int val : map.values()) {
                result *= (val + 1);
            }

            sb.append(result - 1).append("\n");
        }

        System.out.print(sb);
    }
}
