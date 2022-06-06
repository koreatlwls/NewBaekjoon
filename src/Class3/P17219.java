package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P17219 {

    static int N, M;
    static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            map.put(inputs[0], inputs[1]);
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            sb.append(map.get(input)).append("\n");
        }

        System.out.print(sb);
    }
}
