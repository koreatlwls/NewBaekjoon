package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P01138 {

    static int N;
    static int[] inputs;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        inputs = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =1;i<=N;i++){
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=N;i>=1;i--){
            result.add(inputs[i],i);
        }

        for(int num : result){
            System.out.print(num + " ");
        }
    }
}
