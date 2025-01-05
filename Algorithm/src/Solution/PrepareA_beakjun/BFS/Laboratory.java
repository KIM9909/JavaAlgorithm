package Solution.PrepareA_beakjun.BFS;

import java.util.*;
import java.io.*;

public class Laboratory {
    static int N;
    static int M;
    static int[][] arr;
    static int[][] temp_arr;
    static int[] dr = {-1,0,1,0}; // 상, 우, 하, 좌
    static int[] dc = {0,1,0,-1};
    static int max_cnt;
    static int current_cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        max_cnt = 0;

        arr = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        makeWall(0);
        System.out.println(max_cnt);
    }
    // 벽 세우기
    static void makeWall(int cnt) {
        if (cnt == 3) {
            // 임시 배열에 arr 할당 (깊은 복사)
            temp_arr = new int[N][M];
            for (int i=0; i<N; i++) {
                temp_arr[i] = arr[i].clone();
            }
            // bfs
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (temp_arr[i][j] == 2) {
                        bfs(i,j);
                    }
                }
            }
            // 3개의 벽을 세우고 바이러스 확산 후 안전영역 수 체크
            current_cnt = 0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (temp_arr[i][j] == 0) {
                        current_cnt ++;
                    }
                }
            }
            max_cnt = Math.max(max_cnt, current_cnt);
            return;
        }

        // 백트래킹으로 벽 세우고 cnt+1
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    makeWall(cnt + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }
    static void bfs(int a, int b) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {a, b});

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];

            for (int k=0; k<4; k++) {
                int nr = x + dr[k];
                int nc = y + dc[k];

                if (0 <= nr && nr < N && 0 <= nc && nc < M && temp_arr[nr][nc] == 0) {
                    temp_arr[nr][nc] = 2;
                    q.offer(new int[] {nr, nc});
                }
            }
        }
    }
}
