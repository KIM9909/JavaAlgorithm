// 16398. 행성 연결 (prim)
package Solution.Beakjun.Prim;

import java.util.*;
import java.io.*;
public class PlanetConnect {
    static int N;
    static boolean[] visited;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        graph = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long res = prim();
        System.out.println(res);
    }
    static long prim() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {0, 0});

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

            for (int i=0; i<N; i++) {
                if (!visited[i]) {
                    pq.offer(new int[] {i, graph[vertex][i]});
                }
            }
        }
        return totalWeight;
    }
}
