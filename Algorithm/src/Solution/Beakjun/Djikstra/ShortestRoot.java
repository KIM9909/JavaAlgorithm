// djikstra
package Solution.Beakjun.Djikstra;

import java.io.*;
import java.util.*;
public class ShortestRoot {
    static int V, E, K;
    static int start, end, weight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); // 정점 개수
        E = Integer.parseInt(st.nextToken()); // 간선 개수

        K = Integer.parseInt(br.readLine()); // 시작 정점

        // 그래프 만들기 (정점 번호가 1부터 시작하므로 V+1 크기로)
        List<int[]>[] graph = new ArrayList[V+1];
        for (int i=1; i<=V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken()); // 출발 정점
            end = Integer.parseInt(st.nextToken()); // 도착 정점
            weight = Integer.parseInt(st.nextToken()); // 가중치
            graph[start].add(new int[] {end, weight});
        }

        // 최단 거리 저장할 배열
        int[] dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE); // 초기화
        dist[K] = 0; // 시작 정점은 거리가 0

        // 방문 체크
        boolean[] visited = new boolean[V+1];

        // 우선순위 큐 (거리가 짧은 것부터 처리)
        // 거리순으로 정렬 (뺀 값이 음수이면 작은 값이 앞으로)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] {K, 0}); // {정점, 거리}

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentV = current[0];

            if (visited[currentV]) {
                continue;
            } else {
                visited[currentV] = true;
            }

            // 현재 정점과 연결된 모든 정점 확인
            for (int[] next : graph[currentV]) {
                int nextV = next[0];
                int nextWeight = next[1];

                // 더 짧은 경로를 찾았다면 업데이트
                if (dist[currentV] + nextWeight < dist[nextV]) {
                    dist[nextV] = dist[currentV] + nextWeight;
                    pq.add(new int[] {nextV, dist[nextV]});
                }
            }
        }

        for (int i=1; i<=V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}
