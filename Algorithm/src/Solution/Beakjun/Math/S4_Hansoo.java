package Solution.Beakjun.Math;
// 1065. Silver4_한수

import java.io.*;
public class S4_Hansoo {
    static int N;
    static int cnt = 0;
    static char[] chr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i=1; i<=N; i++) {
            String strI = String.valueOf(i);
            chr = new char[strI.length()];

            for (int j=0; j<strI.length(); j++) {
                chr[j] = strI.charAt(j);
            }

            int differ;
            if (chr.length == 1) {
                differ = Integer.parseInt(String.valueOf(chr[0]));
            } else {
                differ = Integer.parseInt(String.valueOf(chr[1])) - Integer.parseInt(String.valueOf(chr[0]));
            }

            boolean isSame = true;

            if (chr.length > 2) {
                for (int j = 2; j < chr.length; j++) {
                    int newDiffer = Integer.parseInt(String.valueOf(chr[j])) - Integer.parseInt(String.valueOf(chr[j-1]));

                    if (differ != newDiffer) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    cnt++;
                }
            } else {
                cnt ++;
            }
        }

        System.out.println(cnt);
    }
}
