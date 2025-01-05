// 21924. 도시 건설 (prim)
package Solution.PrepareA_beakjun.Prim;

import java.io.*;
import java.util.*;
public class CityConstruct {
    static int N, M;
    static int a, b, c;
    static boolean[] visited;
    static ArrayList<ArrayList<int[]>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 건물 수
        M = Integer.parseInt(st.nextToken()); // 도로 수

        visited = new boolean[N+1];
        graph = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        long maxWeight = 0; // 최대 비용

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()); // 출발 정점
            b = Integer.parseInt(st.nextToken()); // 도착 정점
            c = Integer.parseInt(st.nextToken()); // 비용
            maxWeight += c;
            graph.get(a).add(new int[] {b, c});
            graph.get(b).add(new int[] {a, c});
        }

        long res = maxWeight - prim();

        boolean isConnect = true;
        for (int i=1; i<=N; i++) {
            if (!visited[i]) {
                isConnect = false;
                break;
            }
        }

        System.out.println(isConnect ? res : -1);
    }
    static long prim() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {1, 0}); // 정점 1부터 시작

        long totalWeight = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int vertex = current[0];
            int weight = current[1];

            if (visited[vertex]) {
                continue;
            }

            visited[vertex] = true;
            totalWeight += weight;

            for (int[] next : graph.get(vertex)) {
                int nextVertex = next[0];
                int nextWeight = next[1];

                if (!visited[nextVertex]) {
                    pq.offer(new int[] {nextVertex, nextWeight});
                }
            }
        }
        return totalWeight;
    }
}
