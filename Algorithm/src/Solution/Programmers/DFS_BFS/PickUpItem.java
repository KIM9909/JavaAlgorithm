package Solution.Programmers.DFS_BFS;
// Lv.3 아이템 줍기

import java.util.*;
public class PickUpItem {
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] arr = new int[101][101];

        // 모든 직사각형의 내부를 1로 채우기
        for (int[] rec : rectangle) {
            int dx = rec[0] * 2;
            int dy = rec[1] * 2;
            int ux = rec[2] * 2;
            int uy = rec[3] * 2;

            for (int i=dy; i<=uy; i++) {
                for (int j=dx; j<=ux; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        // 테두리를 제외한 내부는 0으로 초기화
        for (int[] rec : rectangle) {
            int dx = rec[0] * 2;
            int dy = rec[1] * 2;
            int ux = rec[2] * 2;
            int uy = rec[3] * 2;

            for (int i=dy+1; i<uy; i++) {
                for (int j=dx+1; j<ux; j++) {
                    arr[i][j] = 0;
                }
            }
        }

        int res = bfs(arr, characterX*2, characterY*2, itemX*2, itemY*2) / 2;

        return res;
    }

    static int bfs(int[][] arr, int characterX, int characterY, int itemX, int itemY) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        visited[characterY][characterX] = true;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {characterY, characterX, 0});

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int y = xy[0];
            int x = xy[1];
            int dist = xy[2];

            if (y == itemY && x == itemX) {
                return dist;
            }

            for (int k=0; k<4; k++) {
                int nr = y + dr[k];
                int nc = x + dc[k];

                if (nr >= 0 && nr < arr.length && nc >= 0 && nc < arr[0].length && !visited[nr][nc] && arr[nr][nc] == 1)  {
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc, dist + 1});
                }
            }
        }

        return -1;
    }
}
