package Solution.Beakjun.DP;

import java.io.*;
public class G5_Ezreal_여눈부터_가네_ㅈㅈ {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int mod = 1000000007;

        if (N == 1) {
            System.out.println(0);
            return;
        }

        long[][] dp = new long[N][3];

        dp[0][1] = 1;
        dp[0][2] = 1;

        for (int i=1; i<N-1; i++) {
            for (int j=0; j<3; j++) {
                if (dp[i-1][j] == 0) {
                    continue;
                }
                dp[i][(j+1) % 3] = (dp[i][(j+1) % 3] + dp[i-1][j]) % mod;

                dp[i][(j+2) % 3] = (dp[i][(j+2) % 3] + dp[i-1][j]) % mod;
            }
        }

        long res = dp[N-2][1];

        System.out.println(res);
    }
}
