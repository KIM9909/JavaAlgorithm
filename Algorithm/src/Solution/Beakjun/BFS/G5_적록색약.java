package Solution.Beakjun.BFS;

import java.io.*;
import java.util.*;
public class G5_적록색약 {
    static int N;
    static String[][] noBlindArr, blindArr;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        noBlindArr = new String[N][N];
        blindArr = new String[N][N];

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<N; j++) {
                noBlindArr[i][j] = String.valueOf(line.charAt(j));
                if (noBlindArr[i][j].equals("G")) {
                    blindArr[i][j] = "R";
                } else {
                    blindArr[i][j] = noBlindArr[i][j];
                }
            }
        }

        int noBlind = 0;
        boolean[][] visited1 = new boolean[N][N];

        int blind = 0;
        boolean[][] visited2 = new boolean[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                String color1 = noBlindArr[i][j];
                String color2 = blindArr[i][j];

                if (!visited1[i][j]) {
                    bfs(i, j, color1, visited1, 0);

                    noBlind ++;
                }

                if (!visited2[i][j]) {
                    bfs(i, j, color2, visited2, 1);

                    blind ++;
                }
            }
        }

        sb.append(noBlind).append(" ").append(blind);

        System.out.println(sb);
    }

    static void bfs (int a, int b, String color, boolean[][] visited, int mark) {
        visited[a][b] = true;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {a, b});

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];

            for (int k=0; k<4; k++) {
                int nr = x + dr[k];
                int nc = y + dc[k];

                if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc] && mark == 0 && noBlindArr[nr][nc].equals(color)) {
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc});
                }

                if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc] && mark == 1 && blindArr[nr][nc].equals(color)) {
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc});
                }
            }
        }
    }
}
