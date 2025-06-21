// 크루스칼: 최소 스패닝 트리
package Solution.Beakjun.Kruskal;

import java.io.*;
import java.util.*;
public class MinSpanningTree2 {
    static int V, E;
    static int A, B, C;
    static int[] parent;

    // x의 루트 노드를 찾는 함수
    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    // x와 y를 같은 집합으로 합치는 함수
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
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 처음에는 자기 자신이 부모
        parent = new int[V+1];
        for (int i=1; i<=V; i++) {
            parent[i] = i;
        }

        // int[] = {시작점, 끝점, 가중치}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            pq.add(new int[] {A, B, C});
        }

        long res = kruskal(pq);
        System.out.println(res);
    }

    static long kruskal(PriorityQueue<int[]> pq) {
        long totalWeight = 0;
        int cnt = 0;

        while (!pq.isEmpty() && cnt < V-1) {
            int[] current = pq.poll();

            // 사이클이 생기지 않는 경우에만 간선 선택
            if (find(current[0]) != find(current[1])) {
                union(current[0], current[1]);
                totalWeight += current[2];
                cnt ++;
            }
        }
        return totalWeight;
    }
}
