package Solution.Beakjun.DP;

import java.io.*;
public class S5_돌_게임 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        boolean[] dp = new boolean[N+1];

        if (N >= 1) {
            dp[1] = true;
        }

        if (N >= 2) {
            dp[2] = false;
        }

        if (N >= 3) {
            dp[3] = true;
        }

        for (int i=4; i<= N; i++) {
            dp[i] = !dp[i-1] || !dp[i-3];
        }

        if (dp[N]) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
