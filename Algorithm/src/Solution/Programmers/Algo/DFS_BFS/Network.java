package Solution.Programmers.Algo.DFS_BFS;
// Lv.3 네트워크

import java.util.*;
public class Network {
    static int cnt = 0;
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                dfs(computers, visited, i);
                cnt ++;
            }
        }

        return cnt;
    }

    static void dfs(int[][] computers, boolean[] visited, int node) {
        visited[node] = true;

        for (int i=0; i<computers.length; i++) {
            if (!visited[i] && computers[node][i] == 1) {
                dfs(computers, visited, i);
            }
        }
    }
}
