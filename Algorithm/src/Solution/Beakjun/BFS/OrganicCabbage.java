package Solution.Beakjun.BFS;

// 1012. 유기농 배추 (BFS)

import java.io.*;
import java.util.*;
public class OrganicCabbage {
    static int T;
    static int M, N, K;
    static int X, Y;
    static int[][] arr;
    static int[] br = {1,0,-1,0}; // 상, 우, 하, 좌
    static int[] bc = {0,1,0,-1};
    static boolean[][] visited;
    static int cnt_worm;
    static Queue<int[]> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N][M];
            visited = new boolean[N][M];

            q = new LinkedList<>();

            for (int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                X = Integer.parseInt(st.nextToken());
                Y = Integer.parseInt(st.nextToken());

                arr[Y][X] = 1;
            }

            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        cnt_worm ++;
                        bfs(i, j);
                    }
                }
            }

            System.out.println(cnt_worm);
            cnt_worm = 0;
        }
    }

    static void bfs(int a, int b) {
        visited[a][b] = true;

        q.offer(new int[] {a, b});

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];

            for (int k=0; k<4; k++) {
                int nr = x + br[k];
                int nc = y + bc[k];

                if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc] && arr[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc});
                }
            }
        }
    }
}
