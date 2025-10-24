package Solution.Beakjun.BFS;

import java.io.*;
import java.util.*;
public class S1_숨바꼭질 {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int res = bfs();

        System.out.println(res);
    }

    static int bfs () {
        boolean[] visited = new boolean[100001];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {N, 0});
        visited[N] = true;

        while (!q.isEmpty()) {
            int[] info = q.poll();
            int pos = info[0];
            int time = info[1];

            if (pos == K) {
                return time;
            }

            if (pos - 1 >= 0 && !visited[pos-1]) {
                visited[pos-1] = true;
                q.offer(new int[] {pos-1, time+1});
            }

            if (pos + 1 <= 100000 && !visited[pos+1]) {
                visited[pos+1] = true;
                q.offer(new int[] {pos+1, time+1});
            }

            if (pos * 2 <= 100000 && !visited[pos*2]) {
                visited[pos*2] = true;
                q.offer(new int[] {pos*2, time+1});
            }
        }

        return -1;
    }
}
