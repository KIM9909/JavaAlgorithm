// 1261. 알고스팟 (다익스트라)
package Solution.PrepareA_beakjun.Djikstra;

import java.io.*;
import java.util.*;
public class AlgoSpot {
    static int N, M;
    static int[] dr = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dc = {0, 1, 0, -1};
    static int[][] arr;
    static int[][] wallCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        wallCnt = new int[N+1][M+1];

        for (int i=1; i<=N; i++) {
            String line = br.readLine();
            for (int j=1; j<=M; j++) {
                arr[i][j] = line.charAt(j-1) - '0';  // j-1로 (문자열은 0부터 시작)
                wallCnt[i][j] = Integer.MAX_VALUE;
            }
        }

        int res = djikstra(1, 1);
        System.out.println(res);
    }

    static int djikstra(int r, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] {r, c, 0});
        wallCnt[r][c] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0];
            int y = current[1];
            int breakWall = current[2];

            if (breakWall > wallCnt[x][y]) {
                continue;
            }

            if (x == N && y == M) {  // 도착점은 (N, M)
                return breakWall;
            }

            for (int k=0; k<4; k++) {
                int nr = x + dr[k];
                int nc = y + dc[k];

                if (nr < 1 || nr > N || nc < 1 || nc > M) {  // 1부터 N,M까지 체크
                    continue;
                }

                int nextWall = breakWall + arr[nr][nc];

                if (nextWall < wallCnt[nr][nc]) {
                    wallCnt[nr][nc] = nextWall;
                    pq.offer(new int[] {nr, nc, nextWall});
                }
            }
        }
        return wallCnt[N][M];
    }
}