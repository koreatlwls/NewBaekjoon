package Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11725 {

    static int N;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        bfs();
        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        parents[1] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int item : list.get(now)) {
                if (parents[item] == 0) {
                    parents[item] = now;
                    queue.add(item);
                }
            }
        }
    }
}
