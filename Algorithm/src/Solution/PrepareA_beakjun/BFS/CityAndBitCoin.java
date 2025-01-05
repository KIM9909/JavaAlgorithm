package Solution.PrepareA_beakjun.BFS;

import java.util.*;
import java.io.*;

public class CityAndBitCoin {
    static int N;
    static int M;
    static int[][] arr;
    static int[][] visited;
    static int[] dr = {0,1}; // 우, 하
    static int[] dc = {1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        visited = new int[M][N];

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        String res = bfs(0,0);
        System.out.println(res);
    }

    static String bfs(int a, int b) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {a, b});
        visited[a][b] = 1;

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];

            if (x==M-1 && y==N-1) {
                return "Yes";
            }

            for (int k=0; k<2; k++) {
                int nr = x + dr[k];
                int nc = y + dc[k];

                if (0 <= nr && nr < M && 0 <= nc && nc < N && arr[nr][nc] == 1 && visited[nr][nc] != 1) {
                    visited[nr][nc] = 1;
                    q.offer(new int[] {nr, nc});
                }
            }
        }
        return "No";
    }
}
