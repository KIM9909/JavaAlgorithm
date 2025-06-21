// 13418. 학교 탐방하기 (크루스칼)
package Solution.Beakjun.Kruskal;

import java.io.*;
import java.util.*;
public class SchoolExploration {
    static int N, M;
    static int A, B, C;
    static int[] parent;
    static PriorityQueue<int[]> pq;
    static PriorityQueue<int[]> pq2;

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 최적 경로 (1부터 정렬)
        pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);

        // 최악 경로 (0부터 정렬)
        pq2 = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{A, B, C});
            pq2.offer(new int[]{A, B, C});
        }

        // 최적의 경로
        long bestRes = kruskal(pq);
        
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        // 최악의 경로
        long worstRes = kruskal(pq2);

        System.out.println(worstRes - bestRes);
    }

    static long kruskal(PriorityQueue<int[]> pq) {
        int upperCnt = 0;
        int cnt = 0;

        while (!pq.isEmpty() && cnt < N) {
            int[] current = pq.poll();

            if (find(current[0]) != find(current[1])) {
                union(current[0], current[1]);
                cnt++;
                if (current[2] == 0) {  // 오르막길
                    upperCnt++;
                }
            }
        }
        return upperCnt * upperCnt;
    }
}