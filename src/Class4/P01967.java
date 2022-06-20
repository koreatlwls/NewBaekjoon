package Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P01967 {

    static int N;
    static List<List<Node>> list;
    static int max = 0;
    static int max_idx = 0;
    static boolean[] visited;

    static class Node{
        int end;
        int weight;

        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, weight));
            list.get(end).add(new Node(start, weight));
        }

        visited = new boolean[N+1];
        visited[1] = true;
        dfs(1,0);

        visited = new boolean[N+1];
        visited[max_idx] = true;
        dfs(max_idx, 0);
        System.out.print(max);
    }

    static void dfs(int idx, int cnt){
        if(max < cnt){
            max = cnt;
            max_idx = idx;
        }

        for(Node node : list.get(idx)){
            if(!visited[node.end]){
                visited[node.end] = true;
                dfs(node.end, cnt + node.weight);
            }
        }
    }
}
