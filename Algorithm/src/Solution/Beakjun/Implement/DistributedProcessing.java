package Solution.Beakjun.Implement;
// 1009. 분산처리

import java.io.*;
import java.util.*;
public class DistributedProcessing {
    static int T;
    static int a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            int last = 1;
            int base = a % 10;

            for (int i=0; i<b; i++) {
                last = (last * base) % 10;
            }

            if (last == 0) {
                sb.append(10).append('\n');
            } else {
                sb.append(last).append('\n');
            }
        }

        System.out.println(sb);
    }
}
