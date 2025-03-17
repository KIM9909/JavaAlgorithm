// 23747. 와드
package Solution.PrepareA_beakjun.BFS;

import java.io.*;
import java.util.*;
public class Ward {
    static int R, C, Hr, Hc;
    static String[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new String[R+1][C+1];
        visited = new boolean[R+1][C+1];

        for (int i=1; i<=R; i++) {
            String line = br.readLine();
            for (int j=1; j<=C; j++) {
                arr[i][j] = String.valueOf(line.charAt(j-1));
            }
        }

        st = new StringTokenizer(br.readLine());
        Hr = Integer.parseInt(st.nextToken());
        Hc = Integer.parseInt(st.nextToken());

        String line = br.readLine();
        processCommands(line);

        // 최종 위치 시야 처리
        visited[Hr][Hc] = true;
        for (int k=0; k<4; k++) {
            int nr = Hr + dr[k];
            int nc = Hc + dc[k];

            if (1 <= nr && nr <= R && 1 <= nc && nc <= C && !visited[nr][nc]) {
                visited[nr][nc] = true;
            }
        }

        // 결과 출력
        StringBuilder result = new StringBuilder();
        for (int i=1; i<=R; i++) {
            for (int j=1; j<=C; j++) {
                if (visited[i][j]) {
                    result.append(".");
                } else {
                    result.append("#");
                }
            }
            result.append("\n");
        }
        System.out.print(result);
    }

    static void processCommands(String commands) {
        for (int i = 0; i < commands.length(); i++) {
            char cmd = commands.charAt(i);

            if (cmd == 'W') {
                // 와드 설치 - BFS로 같은 지형 처리
                bfs(Hr, Hc);
            } else if (cmd == 'L') {
                if (Hc > 1) Hc--;
            } else if (cmd == 'R') {
                if (Hc < C) Hc++;
            } else if (cmd == 'U') {
                if (Hr > 1) Hr--;
            } else if (cmd == 'D') {
                if (Hr < R) Hr++;
            }
        }
    }

    static void bfs(int r, int c) {
        q = new LinkedList<>();
        String terrainType = arr[r][c];

        q.offer(new int[] {r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];

            for (int k=0; k<4; k++) {
                int nr = x + dr[k];
                int nc = y + dc[k];

                if (1 <= nr && nr <= R && 1 <= nc && nc <= C && !visited[nr][nc] && arr[nr][nc].equals(terrainType)) {
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc});
                }
            }
        }
    }
}