package Solution.Beakjun.String;
// 1120. 문자열

import java.util.*;
import java.io.*;
public class Strings {
    static String A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = st.nextToken();
        B = st.nextToken();

        int minDiff = Integer.MAX_VALUE;

        for (int i=0; i<=B.length() - A.length(); i++) {
            int diff = 0;

            for (int j=0; j<A.length(); j++) {
                if (A.charAt(j) != B.charAt(i+j)) {
                    diff ++;
                }
            }

            minDiff = Math.min(minDiff, diff);
        }

        System.out.println(minDiff);
    }
}
