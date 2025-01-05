package Solution.PrepareA_beakjun.DFS;

import java.util.*;
import java.io.*;

public class NumOfIsland {
    static int w;
    static int h;
    static int[][] visited;
    static int[][] arr;
    static int[] dr = {-1,-1,0,1,1,1,0,-1}; // 상, 우상, 우, 우하, 하, 좌하, 좌, 좌상
    static int[] dc = {0,1,1,1,0,-1,-1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            visited = new int[h][w];
            arr = new int[h][w];
            int cnt = 0;

            for (int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i=0; i<h; i++) {
                for (int j=0; j<w; j++) {
                    if (arr[i][j] == 1 && visited[i][j] != 1) {
                        dfs(i, j);
                        cnt += 1;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    static void dfs(int x, int y) {

        visited[x][y] = 1;
        for (int i=0; i<8; i++) {
            int nr = x + dr[i];
            int nc = y + dc[i];
            if (nr < h && nr >= 0 && nc < w && nc >= 0 && arr[nr][nc] == 1 && visited[nr][nc] != 1) {
                visited[nr][nc] = 1;
                dfs(nr, nc);
            }
        }
    }
}
