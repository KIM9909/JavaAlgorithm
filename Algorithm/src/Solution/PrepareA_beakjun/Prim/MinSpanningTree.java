// 프림: 최소 스패닝 트리
package Solution.PrepareA_beakjun.Prim;

import java.io.*;
import java.util.*;
public class MinSpanningTree {
    static int V, E;
    static int A, B, C;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); // 정점 수
        E = Integer.parseInt(st.nextToken()); // 간선 수

        // 인접 리스트 - 각 정점마다 연결된 간선들의 정보 저장
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i=0; i<=V; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[V + 1];

        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            graph.get(A).add(new int[] {B, C});
            graph.get(B).add(new int[] {A, C});
        }

        long res = prim(graph);
        System.out.println(res);
    }
    static long prim(ArrayList<ArrayList<int[]>> graph) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {1, 0}); // 1번 정점부터 시작

        long totalWeight = 0; // 최소 신장 트리의 총 가중치
        int cnt = 0; // 선택한 정점의 개수

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            if (visited[current[0]]) { // 이미 방문한 정점은 스킵
                continue;
            }

            visited[current[0]] = true;
            totalWeight += current[1];
            cnt++;

            if (cnt == V) { // 모든 정점을 선택했으면 종료
                break;
            }

            // 현재 정점과 연결된 간선들을 우선순위 큐에 추가
            for (int[] next : graph.get(current[0])) {
                if (!visited[next[0]]) {
                    pq.offer(next);
                }
            }
        }
        return totalWeight;
    }
}
