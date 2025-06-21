package Solution.Beakjun.DFS;

import java.util.*;
import java.io.*;
public class PipeMove1 {
    static int N;
    static int[][] arr;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        cnt = 0;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 1, 0);
        System.out.println(cnt);
    }

    static void dfs(int x, int y, int dir) {

        if (x == N-1 && y == N-1) {
            cnt ++;
            return;
        }
        // 가로 파이프 : 가로와 대각선 가능
        if (dir == 0) {
            if (y+1 < N && arr[x][y+1] == 0) {
                dfs(x, y+1, 0);
            }
            if (y+1 < N && x+1 < N && arr[x+1][y+1] == 0 && arr[x+1][y] == 0 && arr[x][y+1] == 0) {
                dfs(x+1, y+1, 2);
            }
        }
        // 세로 파이프 : 세로와 대각선 가능
        if (dir == 1) {
            if (x+1 < N && arr[x+1][y] == 0) {
                dfs(x+1, y, 1);
            }
            if (y+1 < N && x+1 < N && arr[x+1][y+1] == 0 && arr[x+1][y] == 0 && arr[x][y+1] == 0) {
                dfs(x+1, y+1, 2);
            }
        }
        // 대각선 파이프 : 가로, 세로, 대각선 가능
        if (dir == 2) {
            if (y+1 < N && arr[x][y+1] == 0) {
                dfs(x, y+1, 0);
            }
            if (x+1 < N && arr[x+1][y] == 0) {
                dfs(x+1, y, 1);
            }
            if (y+1 < N && x+1 < N && arr[x+1][y+1] == 0 && arr[x+1][y] == 0 && arr[x][y+1] == 0) {
                dfs(x+1, y+1, 2);
            }
        }
    }
}
