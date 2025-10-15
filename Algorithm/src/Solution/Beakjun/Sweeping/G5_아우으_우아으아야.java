package Solution.Beakjun.Sweeping;

import java.io.*;
import java.util.*;
public class G5_아우으_우아으아야 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        List<int[]> lines = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lines.add(new int[] {x, y});
        }

        long totalLength = 0;

        int start = lines.get(0)[0];
        int end = lines.get(0)[1];

        for (int i = 1; i < N; i++) {
            int curStart = lines.get(i)[0];
            int curEnd = lines.get(i)[1];

            if (curStart <= end) {
                end = Math.max(end, curEnd);
            }
            else {
                totalLength += (end - start);

                start = curStart;
                end = curEnd;
            }
        }

        totalLength += (end - start);

        System.out.println(totalLength);
    }
}