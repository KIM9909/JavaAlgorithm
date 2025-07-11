package Solution.Programmers.BruteForce;
// Lv.2 전력망 둘로 나누기

import java.util.*;
public class PowerGridDivide {
    public int solution(int n, int[][] wires) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        int minDiff = Integer.MAX_VALUE;

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            tree.get(a).remove(Integer.valueOf(b));
            tree.get(b).remove(Integer.valueOf(a));

            boolean[] visited = new boolean[n+1];
            int group1 = dfs(tree, 1, visited);
            int group2 = n - group1;

            minDiff = Math.min(minDiff, Math.abs(group1 - group2));

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        return minDiff;
    }

    static int dfs(List<List<Integer>> tree, int node, boolean[] visited) {
        visited[node] = true;
        int cnt = 1;

        for (int link : tree.get(node)) {
            if (!visited[link]) {
                cnt += dfs(tree, link, visited);
            }
        }

        return cnt;
    }
}
