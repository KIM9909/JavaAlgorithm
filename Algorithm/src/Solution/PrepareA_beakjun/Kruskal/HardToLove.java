// 14621. 나만 안되는 연애 (크루스칼)
package Solution.PrepareA_beakjun.Kruskal;

import java.util.*;
import java.io.*;
public class HardToLove {
    static int N, M;
    static int u, v, d;
    static int[] parent;
    static char[] genders;
    static PriorityQueue<int[]> pq;

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
        N = Integer.parseInt(st.nextToken()); // 학교 수
        M = Integer.parseInt(st.nextToken()); // 도로 수

        // 각 정점들의 대학 성별 저장
        genders = new char[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            genders[i] = st.nextToken().charAt(0);
        }

        parent = new int[N+1];
        for (int i=1; i<=N; i++) {
            parent[i] = i;
        }

        pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken()); // 출발 학교
            v = Integer.parseInt(st.nextToken()); // 도착 학교
            d = Integer.parseInt(st.nextToken()); // 거리
            pq.offer(new int[] {u, v, d});
        }

        long res = kruskal();
        System.out.println(res);
    }

    static long kruskal() {
        long totalWeight = 0;
        int cnt = 0;

        while (!pq.isEmpty() && cnt < N-1) {
            int[] current = pq.poll();

            // 사이클을 형성하지 않고, 대학 성별이 다를 경우 연결
            if (find(current[0]) != find(current[1])
                && genders[current[0]] != genders[current[1]]) {
                union(current[0], current[1]);
                totalWeight += current[2];
                cnt++;
            }
        }
        // 모든 대학이 연결 될 경우
        if (cnt == N-1) {
            return totalWeight;
        } else {
            return -1;
        }
    }
}
