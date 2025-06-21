package Solution.Beakjun.Djikstra;

import java.io.*;
import java.util.*;

public class Party {
    static int N, M, X;
    static int s, e, t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 마을 수 (학생 수)
        M = Integer.parseInt(st.nextToken()); // 도로 수
        X = Integer.parseInt(st.nextToken()); // 모일 마을 번호

        List<int[]>[] graph = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken()); // 출발 정점
            e= Integer.parseInt(st.nextToken()); // 도착 정점
            t = Integer.parseInt(st.nextToken()); // 소요 시간
            graph[s].add(new int[] {e, t});
        }

        long max_time = 0;
        // N개의 마을에서 출발
        for (int i=1; i<=N; i++) {
            // (출발점 -> 도착점) + (도착점 -> 출발점)
            int min_time = dijkstra(i, X, graph) + dijkstra(X, i, graph);

            // 최단거리 중 최장시간
            max_time = Math.max(max_time, min_time);
        }

        System.out.println(max_time);
    }
    // 다익스트라로 최단 경로 구하기
    static int dijkstra(int start, int end, List<int[]>[] graph) {
        // 시작점과 도착점이 같으면 0시간
        if (start == end) {
            return 0;
        }
        int[] times = new int[N+1];
        Arrays.fill(times, Integer.MAX_VALUE);
        times[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int vertex = current[0];
            int time = current[1];

            if (times[vertex] < time) {
                continue;
            }

            for (int[] next : graph[vertex]) {
                int nextVertex = next[0];
                int nextTime = time + next[1];

                if (times[nextVertex] > nextTime) {
                    times[nextVertex] = nextTime;
                    pq.offer(new int[] {nextVertex, nextTime});
                }
            }
        }
        return times[end];
    }
}
