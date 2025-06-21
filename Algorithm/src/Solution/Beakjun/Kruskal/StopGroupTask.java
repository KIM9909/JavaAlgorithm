// 23034. 조별과제 멈춰! (크루스칼)
package Solution.Beakjun.Kruskal;

import java.io.*;
import java.util.*;
public class StopGroupTask {
    static int N, M;
    static int A, B, C;
    static int Q;
    static int X, Y;
    static int[] parent;
    static ArrayList<int[]> graph;

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

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        graph = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            graph.add(new int[]{A, B, C});
        }

        // graph를 가중치 기준으로 오름차순 정렬해서 우선순위 큐 대신 사용
        Collections.sort(graph, (a, b) -> a[2] - b[2]);

        Q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            // 각 팀장(루트 노드)별 MST 수행
            long res = kruskal(X, Y);
            // 초기화
            for (int j = 0; j <= N; j++) {
                parent[j] = j;
            }
            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }

    static long kruskal(int leader1, int leader2) {
        long totalWeight = 0;
        int cnt = 0;

        // PriorityQueue 대신 사용
        for (int[] current : graph) {

            // 간선 수 제한
            if (cnt == N-2) {
                break;
            }

            // 팀장 노드와 루트 노트들이 같다면 union하지 않고 생략
            if (find(current[0]) == find(leader1) && find(current[1]) == find(leader2)
                    || find(current[0]) == find(leader2) && find(current[1]) == find(leader1)) {
                continue;
            }

            // MST 수행
            if (find(current[0]) != find(current[1])) {
                union(current[0], current[1]);
                totalWeight += current[2];
                cnt++;
            }
        }
        return totalWeight;
    }
}