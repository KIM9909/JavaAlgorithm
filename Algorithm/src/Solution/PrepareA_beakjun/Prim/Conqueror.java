package Solution.PrepareA_beakjun.Prim;

import java.io.*;
import java.util.*;
public class Conqueror {
    static int N, M, t;
    static int A, B, C;
    static boolean[] visited;
    static ArrayList<ArrayList<int[]>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        graph = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            graph.get(A).add(new int[] {B, C});
            graph.get(B).add(new int[] {A, C});
        }

        long res = prim();
        System.out.println(res);
    }

    static long prim() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {1, 0});

        long totalWeight = 0;
        long conquerCity = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int vertex = current[0];
            int weight = current[1];

            if (visited[vertex]) {
                continue;
            }

            visited[vertex] = true;
            if (vertex == 1) {
                totalWeight += 0;
            } else {
                totalWeight += weight + conquerCity * t;
                conquerCity ++;
            }

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
