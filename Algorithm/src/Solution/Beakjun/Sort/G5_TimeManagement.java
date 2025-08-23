package Solution.Beakjun.Sort;
// 1263. Gold5_시간 관리

import java.io.*;
import java.util.*;
public class G5_TimeManagement {
    static int N, T, S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> lst = new ArrayList<>();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());

            lst.add(new int[] {T,S});
        }

        // 마감시간 기준 역순 정렬
        Collections.sort(lst, (a, b) -> b[1] - a[1]);

        int currTime = Integer.MAX_VALUE;

        for (int i=0; i<N; i++) {
            int[] curr = lst.get(i);

            currTime = Math.min(currTime, curr[1]);

            currTime -= curr[0];

            if (currTime < 0) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(currTime);
    }
}
