// 2667. 단지번호붙이기 (BFS ver)
package Solution.Beakjun.BFS;

import java.util.*;
import java.io.*;
public class DanjiNumber {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int cnt;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> houseCounts = new ArrayList<>();

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    cnt = bfs(i, j);
                    houseCounts.add(cnt);
                    count ++;
                }
            }
        }

        Collections.sort(houseCounts);

        System.out.println(count);

        for (int houseCount : houseCounts) {
            sb.append(houseCount).append('\n');
        }
        System.out.println(sb);
    }

    static int bfs(int a, int b) {

        Queue<int[]> q = new LinkedList();
        q.offer(new int[] {a, b});
        visited[a][b] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];

            for (int k=0; k<4; k++) {
                int nr = x + dr[k];
                int nc = y + dc[k];

                if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc] && arr[nr][nc] == 1) {
                    cnt ++;
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc});
                }
            }
        }
        return cnt;
    }
}
