// 2667. 단지번호붙이기 (DFS ver)
package Solution.Beakjun.DFS;

import java.io.*;
import java.util.*;
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
                    cnt = dfs(i, j);
                    houseCounts.add(cnt);
                    count ++;
                }
            }
        }
        System.out.println(count);

        Collections.sort(houseCounts);

        for (int houseCount : houseCounts) {
            sb.append(houseCount).append('\n');
        }
        System.out.println(sb);
    }

    static int dfs(int x, int y) {
        int cnt = 1;
        visited[x][y] = true;
        for (int k=0; k<4; k++) {
            int nr = x + dr[k];
            int nc = y + dc[k];

            if (0 <= nr && nr < N && 0 <= nc && nc < N && arr[nr][nc] == 1 && !visited[nr][nc]) {
                cnt += dfs(nr, nc);
            }
        }
        return cnt;
    }
}
