package Solution.Beakjun.Djikstra;

import java.io.*;
import java.util.*;
public class G5_택배_배송 {
    static int N, M;
    static int A, B, C;
    static List<int[]>[] graph;
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

        int res = dijkstra();
        System.out.println(res);
    }

    static int dijkstra() {
        // N 까지의 최소 비용 배열
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        // 비용 기준 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {1, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curCost = cur[1];

            if (curCost > dist[curNode]) {
                continue;
            }

            for (int[] next : graph[curNode]) {
                int nextNode = next[0];
                int nextCost = next[1];

                int newCost = dist[curNode] + nextCost;

                if (newCost < dist[nextNode]) {
                    dist[nextNode] = newCost;
                    pq.offer(new int[] {nextNode, newCost});
                }
            }
        }

        return dist[N];
    }
}
