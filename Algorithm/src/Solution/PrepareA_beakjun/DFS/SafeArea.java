package Solution.PrepareA_beakjun.DFS;

import java.util.*;
import java.io.*;
public class SafeArea {
    static int[][] arr;
    static int[][] visited;
    static int N;
    static int max_height;
    static int height;
    static int max_cnt;
    static int cnt;
    static int[] dr = {-1,0,1,0}; // 상, 우, 하, 좌
    static int[] dc = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        max_height = 0;
        height = 0;
        max_cnt = 0;
        arr = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (max_height < arr[i][j]) {
                    max_height = arr[i][j];
                }
            }
        }

        while (height != max_height) {
            cnt = 0;
            visited = new int[N][N];
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (arr[i][j] > height && visited[i][j] != 1) {
                        dfs(i, j);
                        cnt += 1;
                    }
                }
            }
            if (max_cnt < cnt) {
                max_cnt = cnt;
            }
            height ++;
        }
        System.out.println(max_cnt);
    }

    static void dfs(int x, int y) {
        visited[x][y] = 1;

        for (int k=0; k<4; k++) {
            int nr = x + dr[k];
            int nc = y + dc[k];

            if (0 <= nr && nr < N && 0 <= nc && nc < N && arr[nr][nc] > height && visited[nr][nc] != 1) {
                visited[nr][nc] = 1;
                dfs(nr, nc);
            }
        }
    }
}
