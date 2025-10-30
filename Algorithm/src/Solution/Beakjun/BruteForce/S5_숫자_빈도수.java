package Solution.Beakjun.BruteForce;

import java.io.*;
import java.util.*;
public class S5_숫자_빈도수 {
    static int n, d;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for (int i=1; i<=n; i++) {
            arr[i-1] = i;
        }

        int cnt = 0;
        for (int a : arr) {
            String aStr = String.valueOf(a);

            for (int i=0; i<aStr.length(); i++) {
                if (String.valueOf(aStr.charAt(i)).equals(String.valueOf(d))) {
                    cnt ++;
                }
            }
        }

        System.out.println(cnt);
    }
}
