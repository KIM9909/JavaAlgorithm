package Solution.Programmers.Algo.Greedy;
// Lv.3 섬 연결하기

import java.util.*;
public class ConnectIsland {
    static int[] parent;
    static PriorityQueue<int[]> pq;

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }

        pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        int cnt = 0;
        int totalWeight = 0;

        for (int[] cost : costs) {
            pq.offer(new int[] {cost[0], cost[1], cost[2]});
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (find(cur[0]) != find(cur[1])) {
                union(cur[0], cur[1]);
                totalWeight += cur[2];
                cnt ++;

                if (cnt == n - 1) {
                    break;
                }
            }
        }

        return totalWeight;
    }
}
