// 2211. 네트워크 복구 (다익스트라)
package Solution.Beakjun.Djikstra;

import java.io.*;
import java.util.*;
public class NetworkRestore {
    static int N, M;
    static int A, B, C;
    static ArrayList<int[]>[] graph;
    static ArrayList<int[]> edges;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            graph[A].add(new int[] {B, C});
            graph[B].add(new int[] {A, C});
        }

        dijkstra(1);

        int cnt = 0;
        edges = new ArrayList<>();

        for (int i=2; i<=N; i++) {
            if (parent[i] != 0) {
                cnt++;
                edges.add(new int[] {parent[i], i});
            }
        }

        System.out.println(cnt);
        for (int[] temp : edges) {
            System.out.println(temp[0] + " " + temp[1]);
        }

    }

    static void dijkstra(int start) {
        parent = new int[N+1];
        int[] times = new int[N+1];
        Arrays.fill(times, Integer.MAX_VALUE);
        times[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int vertex = cur[0];
            int time = cur[1];

            if (time > times[vertex]) {
                continue;
            }

            for (int[] next : graph[vertex]) {
                int nextVertex = next[0];
                int nextTime = time + next[1];

                if (times[nextVertex] > nextTime) {
                    times[nextVertex] = nextTime;
                    parent[nextVertex] = vertex; // 최단 경로에서의 부모 저장
                    pq.offer(new int[] {nextVertex, nextTime});
                }
            }
        }
    }
}
