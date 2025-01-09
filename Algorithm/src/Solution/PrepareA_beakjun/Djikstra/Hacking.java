// 10282. 해킹 (다익스트라)
package Solution.PrepareA_beakjun.Djikstra;

import java.util.*;
import java.io.*;
public class Hacking {
    static int T;
    static int n, d, c;
    static int a, b, s;
    static List<int[]>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n+1];
            for (int k=1; k<=n; k++) {
                graph[k] = new ArrayList<>();
            }

            for (int j=0; j<d; j++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());
                // a가 b에 의존, b는 a에 의존 x
                graph[b].add(new int[] {a, s});
            }

            djikstra(c);
        }
    }
    static void djikstra(int start) {
        int[] times = new int[n+1];
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
                    pq.offer(new int[]{nextVertex, nextTime});
                }
            }
        }
        int cntComputer = 0;
        int resTime = 0;

        for (int i=1; i<=n; i++) {
            if (times[i] != Integer.MAX_VALUE) {
                cntComputer++;
                resTime = Math.max(resTime, times[i]);
            }
        }
        System.out.println(cntComputer + " " + resTime);
    }
}
