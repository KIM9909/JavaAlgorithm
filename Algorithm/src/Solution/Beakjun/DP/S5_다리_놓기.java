package Solution.Beakjun.DP;

import java.io.*;
import java.util.*;
public class S5_다리_놓기 {
    static int T;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        int[][] dp = new int[31][31];

        for (int i=0; i<=30; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for (int i=2; i<=30; i++) {
            for (int j=1; j<i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            sb.append(dp[M][N]).append("\n");
        }

        System.out.println(sb);
    }
}
