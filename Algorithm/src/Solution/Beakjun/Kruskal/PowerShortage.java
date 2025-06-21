// 6497. 전력난 (크루스칼)
package Solution.Beakjun.Kruskal;

import java.io.*;
import java.util.*;
public class PowerShortage {
    static int m, n;
    static int x, y, z;
    static int[] parent;
    static PriorityQueue<int[]> pq;
    static int maxWeight;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            maxWeight = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                z = Integer.parseInt(st.nextToken());
                pq.offer(new int[]{x, y, z});
                maxWeight += z;
            }

            long res = kruskal();
            System.out.println(maxWeight - res);
        }
    }

    static long kruskal() {
        long totalWeight = 0;
        int cnt = 0;

        while (!pq.isEmpty() && cnt < m) {
            int[] current = pq.poll();

            if (find(current[0]) != find(current[1])) {
                union(current[0], current[1]);
                totalWeight += current[2];
                cnt++;
            }
        }
        return totalWeight;
    }
}
