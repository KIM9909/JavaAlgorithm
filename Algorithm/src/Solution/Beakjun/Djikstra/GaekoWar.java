// 2325. 개코전쟁 (다익스트라)
package Solution.Beakjun.Djikstra;

import java.io.*;
import java.util.*;

public class GaekoWar {
    static int N, M;
    static int s, e, w;
    static ArrayList<int[]>[] graph;
    static int[] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        path = new int[N + 1];

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph[s].add(new int[] {e, w});
            graph[e].add(new int[] {s, w});
        }

        // 최초 다익스트라로 기본 최단 경로 찾기 (x=0)
        int res = dijkstra(0);
        // 찾은 최단 경로 상의 간선들을 하나씩 제거해보며
        // 우회 경로 중 최단 시간이 가장 긴 경로 찾기
        for(int i = N; i > 1;) {
            res = Math.max(res, dijkstra(i));
            i = path[i]; // 최단 경로를 따라 역추적
        }

        System.out.println(res);
    }

    static int dijkstra(int x) {
        int[] times = new int[N+1];
        Arrays.fill(times, Integer.MAX_VALUE);
        times[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {1, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int vertex = current[0];
            int time = current[1];

            if (time > times[vertex]) {
                continue;
            }

            for (int[] temp : graph[vertex]) {
                int nextVertex = temp[0];
                int nextTime = temp[1];

                // 제거해야 할 간선인 경우 스킵
                if((vertex == x && nextVertex == path[x]) ||
                        (vertex == path[x] && nextVertex == x)) {
                    continue;
                }

                if (times[nextVertex] > times[vertex] + nextTime) {
                    times[nextVertex] = times[vertex] + nextTime;
                    if(x == 0) { // 최초 경로 탐색시에만 경로 정보 저장
                        path[nextVertex] = vertex;
                    }
                    pq.offer(new int[] {nextVertex, times[nextVertex]});
                }
            }
        }
        return times[N];
    }
}
