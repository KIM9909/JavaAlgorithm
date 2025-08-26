package Solution.Beakjun.String;
// 1439. Silver5_뒤집기

import java.io.*;
public class S5_Flip {
    static String num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = br.readLine();

        int flipCnt = cal();
        System.out.println(flipCnt);
    }

    static int cal() {
        StringBuilder sb = new StringBuilder();
        sb.append(num.charAt(0));

        for (int i=1; i<num.length(); i++) {
            if (num.charAt(i) != num.charAt(i-1)) {
                sb.append(num.charAt(i));
            }
        }

        int cnt0 = 0, cnt1 = 0;
        for (int i=0; i<sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                cnt0 ++;
            } else {
                cnt1 ++;
            }
        }

        return Math.min(cnt0, cnt1);
    }
}
