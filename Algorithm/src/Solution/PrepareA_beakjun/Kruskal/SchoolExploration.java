// 13418. 학교 탐방하기 (크루스칼)
package Solution.PrepareA_beakjun.Kruskal;

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

        pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq2 = new PriorityQueue<>((a, b) -> b[2] - a[2]);

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{A, B, C});
            pq2.offer(new int[]{A, B, C});
        }

        long bestRes = kruskal(pq);

        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        long worstRes = kruskal(pq2);
        System.out.println(worstRes - bestRes);
    }

    static long kruskal(PriorityQueue<int[]> pq) {
        int upperCnt = 0;
        int cnt = 0;

        while (!pq.isEmpty() && cnt < N-1) {
            int[] current = pq.poll();

            if (find(current[0]) != find(current[1])) {
                union(current[0], current[1]);
                cnt++;
                if (current[2] == 1) {
                    upperCnt++;
                }
            }
        }
        return upperCnt * upperCnt;
    }
}