package Solution.Programmers.Algo.DFS_BFS;
// Lv.2 게임 맵 최단거리

import java.util.*;
public class ShortestRootGameMap {
    static int[] dr = {1, 0, -1, 0}; // 상우하좌
    static int[] dc = {0, 1, 0, -1};
    static int minCnt = Integer.MAX_VALUE;
    public int solution(int[][] maps) {
        minCnt = Math.min(minCnt, bfs(0, 0, maps));

        return minCnt;
    }

    static int bfs(int a, int b, int[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        visited[a][b] = true;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {a, b, 1});

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];
            int dist = xy[2];

            if (x == arr.length-1 && y == arr[0].length-1) {
                return dist;
            }

            for (int k=0; k<4; k++) {
                int nr = x + dr[k];
                int nc = y + dc[k];

                if (0 <= nr && nr < arr.length && 0 <= nc && nc < arr[0].length && arr[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc, dist+1});
                }
            }
        }

        return -1;
    }
}
