// 1647. 도시 분할 계획 (크루스칼)
package Solution.Beakjun.Kruskal;

import java.io.*;
import java.util.*;
public class CityDividePlan {
    static int N, M;
    static int A, B, C;
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for (int i=1; i<=N; i++) {
            parent[i] = i;
        }

        pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            pq.add(new int[] {A, B, C});
        }

        long res = kruskal();
        System.out.println(res);
    }

    static long kruskal() {
        long totalWeight = 0;
        int cnt = 0;
        long maxWeight = 0; // 선택된 간선 중 가장 큰 유지비

        while (!pq.isEmpty() && cnt < N-1) {
            int[] current = pq.poll();

            if (find(current[0]) != find(current[1])) {
                union(current[0], current[1]);
                totalWeight += current[2];
                maxWeight = Math.max(maxWeight, current[2]); // 최대 유지비
                cnt++;
            }
        }
        return totalWeight - maxWeight; // 최대 유지비를 가진 간선 제거 (도시 분할)
    }
}
