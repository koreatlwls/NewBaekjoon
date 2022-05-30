import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P01620 {

    static int N, M;
    static HashMap<String, Integer> map = new HashMap<>();
    static String[] name;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        name = new String[N + 1];

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            map.put(input, i);
            name[i] = input;
        }

        for (int i = 0; i < M; i++) {
            String find = br.readLine();

            if (isString(find)) {
                int index = Integer.parseInt(find);
                sb.append(name[index]);
            } else {
                sb.append(map.get(find));
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }

    static boolean isString(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
