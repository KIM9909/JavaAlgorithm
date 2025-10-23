package Solution.Beakjun.Math;

import java.io.*;
import java.util.*;
public class S5_곱셈을_누가_이렇게_해_ㅋㅋ {
    static int T;
    static String A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            A = st.nextToken();
            B = st.nextToken();

            long num = Long.parseLong(A) * Long.parseLong(B);

            String longer;
            String shorter;

            if (A.length() > B.length()) {
                longer = A;
                shorter = B;
            } else {
                longer = B;
                shorter = A;
            }

            String strNum = multi(longer, shorter);

            if (num == Long.parseLong(strNum)) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }

        System.out.println(sb);
    }

    static String multi (String longer, String shorter) {
        StringBuilder res = new StringBuilder();

        int diff = longer.length() - shorter.length();

        for (int i=0; i<longer.length(); i++) {
            int longerNum = longer.charAt(i) - '0';

            if (i < diff) {
                res.append(longerNum);
            } else {
                int shorterNum = shorter.charAt(i - diff) - '0';
                res.append(longerNum * shorterNum);
            }
        }

        return res.toString();
    }
}
