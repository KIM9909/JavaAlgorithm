package Solution.Programmers.Algo.A_CodingTestPre;

import java.util.*;
public class Lv2_완전범죄 {
    static int minA = Integer.MAX_VALUE;
    static int[][] info;
    static int n, m;
    public int solution(int[][] info, int n, int m) {
        this.info = info;
        this.n = n;
        this.m = m;

        Set<String> visited = new HashSet<>();

        dfs(0, 0, 0, visited);

        return minA == Integer.MAX_VALUE ? -1 : minA;
    }

    static void dfs(int aTrace, int bTrace, int idx, Set<String> visited) {
        if (idx == info.length) {
            if (aTrace < n && bTrace < m) {
                minA = Math.min(minA, aTrace);
            }

            return;
        }

        String key = aTrace + "," + bTrace + "," + idx;
        if (visited.contains(key)) {
            return;
        }

        if (aTrace + info[idx][0] < n) {
            dfs(aTrace + info[idx][0], bTrace, idx + 1, visited);
        }

        if (bTrace + info[idx][1] < m) {
            dfs(aTrace, bTrace + info[idx][1], idx + 1, visited);
        }

        visited.add(key);
    }
}
