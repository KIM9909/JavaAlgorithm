// djikstra
package Solution.PrepareA_beakjun.Djikstra;

import java.io.*;
import java.util.*;

public class SpecificShortestRoot {
    static int N, E;
    static int a, b, c;
    static int v1, v2;
    static int INF;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점 개수
        E = Integer.parseInt(st.nextToken()); // 간선 개수
        INF = Integer.MAX_VALUE;

        List<int[]>[] graph = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()); // 출발 정점
            b = Integer.parseInt(st.nextToken()); // 도착 정점
            c = Integer.parseInt(st.nextToken()); // 거리
            graph[a].add(new int[] {b, c});
            graph[b].add(new int[] {a, c}); // 양방향
        }

        // 반드시 거쳐야 하는 두 정점
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        // 경로 1: 1 -> v1 -> v2 -> N
        long path1 = 0;
        path1 += dijkstra(1, v1, graph); // 1에서 v1까지의 최단거리
        path1 += dijkstra(v1, v2, graph); // v1 -> v2
        path1 += dijkstra(v2, N, graph); // v2 -> N

        // 경로 2: 2 -> v2 -> v1 -> N
        long path2 = 0;
        path2 += dijkstra(1, v2, graph); // 1에서 v2까지의 최단거리
        path2 += dijkstra(v2, v1, graph); // v2 -> v1
        path2 += dijkstra(v1, N, graph); // v1 -> N

        long ans = Math.min(path1, path2);

        // 경로가 존재하지 않을 경우 -1 출력
        if (ans >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
    static int dijkstra(int start, int end, List<int[]>[] graph) {
        // 최단 거리를 저장할 배열
        int[] dist = new int[N+1];
        // 모든 거리를 무한대로 초기화
        Arrays.fill(dist, INF);
        // 출발 정점의 거리가 0
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int vertex = current[0]; // 현재 정점
            int distance = current[1]; // 시작점에서 현재 정점까지의 거리

            if (dist[vertex] < distance) {
                continue;
            }

            // 현재 정점과 연결된 모든 정점 확인
            for (int[] next : graph[vertex]) {
                int nextVertex = next[0]; // 다음 정점
                int nextDistance = distance + next[1]; // 시작점에서 다음 정점까지의 거리

                // 더 짧은 경로일 경우 업데이트
                if (dist[nextVertex] > nextDistance) {
                    dist[nextVertex] = nextDistance;
                    pq.offer(new int[] {nextVertex, nextDistance});
                }
            }
        }
        return dist[end];
    }
}
