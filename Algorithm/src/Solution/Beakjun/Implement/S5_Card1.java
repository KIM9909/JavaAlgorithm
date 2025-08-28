package Solution.Beakjun.Implement;
// 2161. Silver5_카드1

import java.io.*;
import java.util.*;
public class S5_Card1 {
    static int N;
    static Queue<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        q = new LinkedList<>();

        for (int i=1; i<=N; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            int remove = q.peek();
            q.poll();
            sb.append(remove).append(" ");
            if (!q.isEmpty()) {
                int peek = q.peek();
                q.poll();
                q.offer(peek);
            }
        }

        System.out.println(sb.toString());
    }
}
