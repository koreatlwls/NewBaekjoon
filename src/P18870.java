import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P18870 {

    static int N;
    static int[] inputs;
    static int[] sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        inputs = new int[N];
        sorted = new int[N];
        HashMap<Integer, Integer> rankMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            sorted[i] = inputs[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        int rank = 0;
        for(int num : sorted){
            if(!rankMap.containsKey(num)){
                rankMap.put(num,rank);
                rank++;
            }
        }

        for(int key : inputs){
            int ranking = rankMap.get(key);
            sb.append(ranking).append(" ");
        }

        System.out.print(sb);
    }
}
