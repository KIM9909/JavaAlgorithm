package Solution.Beakjun.Sort;

import java.io.*;
import java.util.*;
public class S5_역원소_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        int idx = 0;

        while (idx < n) {
            while (st.hasMoreTokens() && idx < n) {
                String num = st.nextToken();

                String reversed = new StringBuilder(num).reverse().toString();

                arr[idx++] = Long.parseLong(reversed);
            }

            if (idx < n) {
                st = new StringTokenizer(br.readLine());
            }
        }

        Arrays.sort(arr);

        for (long num : arr) {
            sb.append(num).append('\n');
        }

        System.out.print(sb);
    }
}