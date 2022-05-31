import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P01764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> nMap = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            nMap.put(input, i);
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (nMap.containsKey(input)) {
                result.add(input);
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
