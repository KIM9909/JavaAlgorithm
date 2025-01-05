package Solution.PrepareA_beakjun.DP;

import java.io.*;

public class MakeOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 연산 횟수를 담을 dp 리스트 생성
        int[] dp = new int[N+1];

        // N이 2이상부터 주어지므로 dp[0]과 dp[1]은 자동으로 0
        for (int i = 2; i < N+1; i++) {

            // N이 2와 3으로 나누어 지지 않을 경우 -1 연산
            dp[i] = dp[i-1] + 1;

            // N이 2로 나누어질 수 있는 경우 -1 연산과 /2 연산 중 작은 것
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }

            // N이 2로 나누어질 수 있는 경우 -1 연산과 /3 연산 중 작은 것
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}
