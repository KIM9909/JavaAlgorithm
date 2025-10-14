package Solution.Beakjun.Recursive;

import java.io.*;
import java.util.*;
public class G5_하노이_탑_이동_순서 {
    static int N;
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        recursive(N, 1, 3, 2);

        System.out.println(cnt);
        System.out.println(sb.toString());
    }

    static void recursive(int N, int start, int end, int via) {
        if (N == 1) {
            cnt ++;
            sb.append(start).append(" ").append(end).append('\n');
            return;
        }

        recursive(N-1, start, via, end);

        cnt ++;
        sb.append(start).append(" ").append(end).append('\n');

        recursive(N-1, via, end, start);
    }
}
