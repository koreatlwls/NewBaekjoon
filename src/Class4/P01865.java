package Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P01865 {

    static int N, M, W;
    static int[] dist;
    static List<List<Road>> list;
    static final int INF = 987654321;

    static class Road {
        int end;
        int weight;

        public Road(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            dist = new int[N + 1];
            list = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < M + W; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                if (i < M) {
                    list.get(start).add(new Road(end, weight));
                    list.get(end).add(new Road(start, weight));
                } else {
                    list.get(start).add(new Road(end, -weight));
                }
            }

            sb.append(bellmanFord() ? "YES\n" : "NO\n");
        }

        System.out.print(sb);
    }

    static boolean bellmanFord() {
        Arrays.fill(dist, INF);
        dist[1] = 0;
        boolean update = false;

        for (int i = 1; i < N; i++) {
            update = false;

            for (int j = 1; j <= N; j++) {
                for (Road road : list.get(j)) {
                    if (dist[road.end] > dist[j] + road.weight) {
                        dist[road.end] = dist[j] + road.weight;
                        update = true;
                    }
                }
            }

            if (!update) {
                break;
            }
        }

        if (update) {
            for (int i = 1; i <= N; i++) {
                for (Road road : list.get(i)) {
                    if (dist[road.end] > dist[i] + road.weight) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
