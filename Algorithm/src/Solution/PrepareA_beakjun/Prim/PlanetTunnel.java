// 2887. 행성 터널 (prim)
package Solution.PrepareA_beakjun.Prim;

import java.util.*;
import java.io.*;
public class PlanetTunnel {
    static int N;
    static int x, y, z;
    static boolean[] visited;
    static ArrayList<ArrayList<int[]>> graph;
    static int[][] planets;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        planets = new int[N+1][4];
        graph = new ArrayList<>();

        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());
            planets[i][0] = i; // 행성 번호
            planets[i][1] = x;
            planets[i][2] = y;
            planets[i][3] = z;
        }

        // x, y, z축 별로 정렬 및 인접한 간선 추가
        for (int k=1; k<=3; k++) {
            int axis = k;
            // 정렬
            Arrays.sort(planets, 1, N+1, (a, b) -> a[axis] - b[axis]);

            // 간선 추가
            for (int i=2; i<=N; i++) {
                // 터널 연결 비용 계산
                int cost = Math.abs(planets[i-1][axis] - planets[i][axis]);
                int p1 = planets[i-1][0]; // 첫 번째 행성
                int p2 = planets[i][0]; // 두 번째 행성
                graph.get(p1).add(new int[] {p2, cost});
                graph.get(p2).add(new int[] {p1, cost});
            }
        }

        long res = prim();
        System.out.println(res);
    }

    static long prim() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {1, 0});

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
                pq.offer(new int[] {nextVertex, nextWeight});
            }
        }

        return totalWeight;
    }
}
