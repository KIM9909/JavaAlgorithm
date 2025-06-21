// 14497. 주난의 난(難) (다익스트라)
package Solution.Beakjun.Djikstra;

import java.util.*;
import java.io.*;
public class NanOfJoonan {
    static int N, M;
    static int x1, y1, x2, y2;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken())-1;
        y1 = Integer.parseInt(st.nextToken())-1;
        x2 = Integer.parseInt(st.nextToken())-1;
        y2 = Integer.parseInt(st.nextToken())-1;

        arr = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        System.out.println(dijkstra());
    }

    static int dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] {x1, y1, 0});
        visited[x1][y1] = true;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0];
            int y = current[1];
            int jump = current[2];

            if (x == x2 && y == y2) {
                return jump;
            }

            for (int k = 0; k < 4; k++) {
                int nx = x + dr[k];
                int ny = y + dc[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (arr[nx][ny] == '0') {
                        pq.offer(new int[] {nx, ny, jump});
                    } else {
                        pq.offer(new int[] {nx, ny, jump + 1});
                    }
                }
            }
        }
        return -1;
    }
}
