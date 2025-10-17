package Solution.Beakjun.BFS;

import java.io.*;
import java.util.*;
public class G5_토마토_1 {
    static int N, M;
    static int[][] arr;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        Queue<int[]> q = new LinkedList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        int days = bfs(q);

        boolean isCan = true;
        for (int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    isCan = false;
                    break;
                }
            }
        }

        int res = isCan ? days : -1;

        System.out.println(res);
    }

    static int bfs(Queue<int[]> q) {
        int day = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] xy = q.poll();
                int x = xy[0];
                int y = xy[1];

                for (int k = 0; k < 4; k++) {
                    int nr = x + dr[k];
                    int nc = y + dc[k];

                    if (0 <= nr && nr < N && 0 <= nc && nc < M && arr[nr][nc] == 0) {
                        arr[nr][nc] = 1;

                        q.offer(new int[]{nr, nc});
                    }
                }
            }

            if (!q.isEmpty()) {
                day ++;
            }
        }
        return day;
    }
}
