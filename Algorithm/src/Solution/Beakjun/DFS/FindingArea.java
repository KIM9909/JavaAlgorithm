package Solution.Beakjun.DFS;
// 2583. 영역 구하기

import java.util.*;
import java.io.*;
public class FindingArea {
    static int M, N, K;
    static int dx, dy, ux, uy;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static int[][] arr;
    static boolean[][] visited;
    static List<Integer> areas = new ArrayList<>();
    static int areaCnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        visited = new boolean[M][N];

        for (int t=0; t<K; t++) {
            st = new StringTokenizer(br.readLine());
            dx = Integer.parseInt(st.nextToken());
            dy = Integer.parseInt(st.nextToken());
            ux = Integer.parseInt(st.nextToken());
            uy = Integer.parseInt(st.nextToken());

            for (int i=dy; i<uy; i++) {
                for (int j=dx; j<ux; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if (arr[i][j] == 0 && !visited[i][j]) {
                    int cnt = dfs(i, j);
                    areas.add(cnt);
                    areaCnt++;
                }
            }
        }

        Collections.sort(areas);

        for (int area : areas) {
            sb.append(area).append(" ");
        }

        System.out.println(areaCnt);
        System.out.println(sb);
    }

    static int dfs(int x, int y) {
        visited[x][y] = true;
        int cnt = 1;

        for (int k=0; k<4; k++) {
            int nr = x + dr[k];
            int nc = y + dc[k];

            if (0 <= nr && nr < M && 0 <= nc && nc < N && !visited[nr][nc] && arr[nr][nc] == 0) {
                visited[nr][nc] = true;
                cnt += dfs(nr, nc);
            }
        }

        return cnt;
    }
}
