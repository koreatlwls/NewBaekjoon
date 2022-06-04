package Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class P02481 {

    static int N,K;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[N+1];

        for(int i=0;i<=N;i++){
            visited[i] = -1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int first = 0;

        for(int i=1;i<=N;i++){
            int num = Integer.parseInt(br.readLine(), 2);

            map.put(num,i);

            if(i==1){
                first = num;
            }
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(first);
        visited[1] = 1;

        while(!q.isEmpty()){
            int val = q.poll();
            int idx = map.get(val);

            for(int i=0;i<K; i++){
                int nextVal = val ^(1<<i);

                if(map.containsKey(nextVal)){
                    int nextIdx = map.get(nextVal);
                    if(visited[nextIdx] == -1){
                        q.offer(nextVal);
                        visited[nextIdx] = idx;
                    }
                }
            }
        }

        int M = Integer.parseInt(br.readLine());

        for(int i=0;i<M;i++){
            int num = Integer.parseInt(br.readLine());

            Stack<Integer> stack = new Stack<>();

            if(visited[num] == -1){
                sb.append("-1").append("\n");
                continue;
            }

            while(true){
                stack.push(num);

                if(num == 1)
                    break;

                num = visited[num];
            }

            while(!stack.isEmpty()){
                sb.append(stack.pop()).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
