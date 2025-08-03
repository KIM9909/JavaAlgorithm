package Solution.Programmers.Graph;
// Lv.3 순위

import java.util.*;
public class Lv3_Ranking {
    static List<List<Integer>> winGraph;
    static List<List<Integer>> loseGraph;

    public int solution(int n, int[][] results) {
        winGraph = new ArrayList<>();
        loseGraph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            winGraph.add(new ArrayList<>());
            loseGraph.add(new ArrayList<>());
        }

        for (int[] res : results) {
            int win = res[0];
            int lose = res[1];

            winGraph.get(win).add(lose);
            loseGraph.get(lose).add(win);
        }

        // 순위를 명확히 하기 위해서는
        // 순위가 높은 선수 수 + 자신보다 순위가 낮은 선수 수 = n-1 이어야 함
        int cnt = 0;
        for (int i=1; i<=n; i++) {
            boolean[] visited = new boolean[n+1];
            int winCnt = dfs(i, visited, winGraph) - 1;

            visited = new boolean[n+1];
            int loseCnt = dfs(i, visited, loseGraph) - 1;

            if (winCnt + loseCnt == n-1) {
                cnt ++;
            }
        }

        return cnt;
    }

    static int dfs (int node, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true;
        int cnt = 1;

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                cnt += dfs(next, visited, graph);
            }
        }

        return cnt;
    }
}
