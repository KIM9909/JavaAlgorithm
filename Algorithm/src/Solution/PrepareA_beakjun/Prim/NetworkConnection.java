package Solution.PrepareA_beakjun.Prim;

import java.io.*;
import java.util.*;
public class NetworkConnection {
    static int N, M;
    static int a, b, c;
    static boolean[] visited;
    static ArrayList<ArrayList<int[]>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 컴퓨터 수 (정점 수)
        M = Integer.parseInt(br.readLine()); // 선의 수 (간선 수)

        graph = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[N+1];

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[] {b, c});
            graph.get(b).add(new int[] {a, c});
        }

        long res = prim();
        System.out.println(res);
    }

    static long prim() {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {1, 0});

        int totalCost = 0;
        int cnt = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            if (visited[current[0]]) {
                continue;
            }

            visited[current[0]] = true;
            totalCost += current[1];
            cnt ++;

            if (cnt == N) {
                break;
            }

            for (int[] next : graph.get(current[0])) {
                if (!visited[next[0]]) {
                    pq.offer(new int[] {next[0], next[1]});
                }
            }
        }
        return totalCost;
    }
}
