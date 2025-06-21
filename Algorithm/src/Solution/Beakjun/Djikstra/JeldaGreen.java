// 4485. 녹색 옷 입은 애가 젤다지? (다익스트라)
package Solution.Beakjun.Djikstra;

import java.util.*;
import java.io.*;
public class JeldaGreen {
    static int N;
    static int[][] arr;
    static int[][] loopy;
    static int[] dr = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = 0;

        while (true) {
            num ++;
            N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            arr = new int[N][N];
            loopy = new int[N][N];

            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    loopy[i][j] = Integer.MAX_VALUE;
                }
            }

            int res = djikstra(0, 0);
            System.out.println("Problem " + num + ": " + res);
        }
    }

    static int djikstra(int r, int c) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] {r, c, arr[r][c]});
        loopy[r][c] = arr[r][c];

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0];
            int y = current[1];
            int curLoopy = current[2];

            if (curLoopy > loopy[x][y]) {
                continue;
            }

            if (x == N-1 && y == N-1) {
                return curLoopy;
            }

            for (int k=0; k<4; k++) {
                int nr = x + dr[k];
                int nc = y + dc[k];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    continue;
                }

                int nextLoopy = curLoopy + arr[nr][nc];

                if (nextLoopy < loopy[nr][nc]) {
                    loopy[nr][nc] = nextLoopy;
                    pq.offer(new int[] {nr, nc, nextLoopy});
                }
            }
        }
        return loopy[N-1][N-1];
    }
}
