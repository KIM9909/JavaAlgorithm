package Solution.Beakjun.DFS;

import java.util.*;
import java.io.*;
public class RobotCleaner {
    static int N;
    static int M;
    static int r;
    static int c;
    static int d;
    static int cnt;
    static int[][] arr;
    static int[][] is_cleaned;
    static int[] dr = {-1,0,1,0}; // 상, 우, 하, 좌
    static int[] dc = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        is_cleaned = new int[N][M];
        cnt = 0;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (i==r && j==c) {
                    clean(i, j);
                }
            }
        }
        System.out.println(cnt);
    }

    static void clean(int x, int y) {
        boolean flag = false;

        // 청소하지 않은 자리라면
        if (is_cleaned[x][y] == 0) {
            is_cleaned[x][y] = 1;
            cnt ++;
        }

        // 주변에 청소하지 않은 곳이 있는지 확인
        for (int k=0; k<4; k++) {
            int nr = x + dr[k];
            int nc = y + dc[k];

            if (0 <= nr && nr < N && 0 <= nc && nc < M
                    && arr[nr][nc] == 0 && is_cleaned[nr][nc] == 0) {
                flag = true;
                break;
            }
        }

        // 청소하지 않은 곳이 없을 경우
        if (!flag) {
            int back = (d+2) % 4;
            int nr = x + dr[back];
            int nc = y + dc[back];

            // 뒤로 갈 수 있다면 뒤로 간 후 다시 시작
            if (0 <= nr && nr < N && 0 <= nc && nc < M && arr[nr][nc] == 0) {
                clean(nr, nc);
            }

          // 청소하지 않을 곳이 있을 경우
        } else {
            // 90도 반시계 방향 회전
            d = (d+3) % 4;
            int nr = x + dr[d];
            int nc = y + dc[d];

            // 회전한 방향 앞에 청소하지 않은 곳이 있을 경우
            if (0 <= nr && nr < N && 0 <= nc && nc < M && arr[nr][nc] == 0 && is_cleaned[nr][nc] != 1) {
                clean(nr, nc);

              // 회전한 방향에 없을 경우 (또 회전해야 함)
            } else {
                clean(x, y);
            }
        }
    }
}

