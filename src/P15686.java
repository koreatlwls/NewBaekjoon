import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P15686 {

    static int N, M;
    static int MIN = Integer.MAX_VALUE;
    static List<Position> chicken = new ArrayList<>();
    static List<Position> home = new ArrayList<>();
    static boolean[] visited;

    static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    home.add(new Position(i, j));
                } else if (num == 2) {
                    chicken.add(new Position(i, j));
                }
            }
        }

        visited = new boolean[chicken.size()];

        combination(0, 0);

        System.out.println(MIN);
    }

    static void combination(int cnt, int idx) {
        if (cnt == M) {
            calculateDistance();
            return;
        }

        for(int i=idx;i<chicken.size();i++){
            visited[i] = true;
            combination(cnt+1,i+1);
            visited[i] = false;
        }
    }

    static void calculateDistance() {
        int sum = 0;
        for (int i = 0; i < home.size(); i++) {
            int min_distance = Integer.MAX_VALUE;
            for (int j = 0; j < chicken.size(); j++) {
                if(visited[j]) {
                    int distance = Math.abs(home.get(i).row - chicken.get(j).row) + Math.abs(home.get(i).col - chicken.get(j).col);
                    min_distance = Math.min(min_distance, distance);
                }
            }
            sum += min_distance;
        }

        MIN = Math.min(MIN,sum);
    }
}
