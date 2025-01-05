package Solution.PrepareA_beakjun.DP;

import java.util.*;
import java.io.*;
public class GoDown {
    static int N;
    static int[][] arr;
    static int[][] max_dp;
    static int[][] min_dp;
    static int max_score;
    static int min_score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        max_dp = new int[N][3];
        min_dp = new int[N][3];
        max_score = 0;
        min_score = 0;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        max_dp[0] = min_dp[0] = arr[0];

        for (int i=1; i<N; i++) {
            for (int j=0; j<3; j++) {
                if (j==0) {
                    max_dp[i][j] = Math.max(max_dp[i-1][0], max_dp[i-1][1]) + arr[i][j];
                    min_dp[i][j] = Math.min(min_dp[i-1][0], min_dp[i-1][1]) + arr[i][j];
                } else if (j==1) {
                    max_dp[i][j] = Math.max(Math.max(max_dp[i-1][0], max_dp[i-1][1]), max_dp[i-1][2]) + arr[i][j];
                    min_dp[i][j] = Math.min(Math.min(min_dp[i-1][0], min_dp[i-1][1]), min_dp[i-1][2]) + arr[i][j];
                } else  if (j==2) {
                    max_dp[i][j] = Math.max(max_dp[i-1][1], max_dp[i-1][2]) + arr[i][j];
                    min_dp[i][j] = Math.min(min_dp[i-1][1], min_dp[i-1][2]) + arr[i][j];
                }
            }
        }
        max_score = Math.max(Math.max(max_dp[N-1][0], max_dp[N-1][1]), max_dp[N-1][2]);
        min_score = Math.min(Math.min(min_dp[N-1][0], min_dp[N-1][1]), min_dp[N-1][2]);

        StringBuilder sb = new StringBuilder();
        sb.append(max_score);
        sb.append(" ");
        sb.append(min_score);

        System.out.println(sb);
    }
}
