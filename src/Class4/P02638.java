package Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class P02638 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(true) {
            Queue<Integer[]> q = new LinkedList<>();
            q.add(new Integer[]{0,0});
            map[0][0]=-1;
            while(!q.isEmpty()) {
                Integer[] tmp = q.poll();
                int x = tmp[0];
                int y = tmp[1];
                for(int i=0;i<4;i++) {
                    int nowx = x+dx[i];
                    int nowy = y+dy[i];
                    if(nowx<0||nowy<0||nowx>=n||nowy>=m) {
                        continue;
                    }
                    if(map[nowx][nowy]==0) {
                        map[nowx][nowy]=-1;
                        q.add(new Integer[] {nowx,nowy});
                    }
                }
            }

            Queue<Integer> xx = new LinkedList<>();
            Queue<Integer> yy = new LinkedList<>();

            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    int cnt = 0;
                    if(map[i][j]==1) {
                        for(int d=0;d<4;d++) {
                            int nowx = i+dx[d];
                            int nowy = j+dy[d];
                            if(nowx<0||nowy<0||nowx>=n||nowy>=m) {
                                continue;
                            }

                            if(map[nowx][nowy]==-1) {
                                cnt ++;
                                if(cnt>=2) break;
                            }
                        }
                        if(cnt>=2) {
                            xx.add(i);
                            yy.add(j);
                        }
                    }
                }
            }
            if(xx.isEmpty()) {
                System.out.println(res);
                System.exit(0);
            }

            res++;
            while(!xx.isEmpty()) {
                map[xx.poll()][yy.poll()] = 0;
            }
            for(int i = 0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    if(map[i][j]==-1) {
                        map[i][j]=0;
                    }
                }
            }
        }
    }
}