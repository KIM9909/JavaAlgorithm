package Solution.Beakjun.BFS;
// 2178. Silver1_미로 탐색

import java.io.*;
import java.util.*;
public class S1_MazeSearch {
    static int N, M;
    static char[][] arr;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<M; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int res = bfs(0, 0);

        System.out.println(res);
    }

    static int bfs(int a, int b) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        visited[a][b] = true;
        q.offer(new int[] {a, b, 1});

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];
            int dist = xy[2];

            if (x == N -1 && y == M-1) {
                return dist;
            }

            for (int k=0; k<4; k++) {
                int nr = x + dr[k];
                int nc = y + dc[k];

                if (0 <= nr && nr < N && 0 <= nc && nc < M && arr[nr][nc] == '1' && !visited[nr][nc]) {
                    q.offer(new int[] {nr, nc, dist + 1});
                    visited[nr][nc] = true;
                }
            }
        }

        return -1;
    }
}
