package Solution.Beakjun.DP;

import java.util.*;
import java.io.*;
public class PipeMove2 {
    static int N;
    static long res;
    static int[][] arr;
    static long[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        // 3차원 dp 배열 : (가로, 세로, 대각선 방향 파이프)
        dp = new long[N][N][3];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][1][0] = 1; // 시작
        // 첫 행 가로 파이프 초기 값 설정
        for (int j=2; j<N; j++) {
            if (arr[0][j] == 0) {
                dp[0][j][0] = dp[0][j-1][0];
            }
        }
        // 두 번째 행부터
        for (int i=1; i<N; i++) {
            for (int j=0; j<N; j++) {

                if (arr[i][j] == 1) {
                    continue;
                }
                // j-1에 있던 값을 조건 부합 시 j에 더해줌 (가로 방향)
                if (j-1>=0 && arr[i][j-1] == 0) {
                    dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2]; // 가로 파이프 : 가로 + 대각선
                }
                // i-1에 있던 값을 조건 부합 시 i에 더해줌 (세로 방향)
                if (i-1>=0 && arr[i-1][j] == 0) {
                    dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2]; // 세로 파이프 : 세로 + 대각선
                }
                // 대각선 방향
                if (i-1>=0 && j-1>=0 && arr[i][j-1] == 0 && arr[i-1][j] == 0 && arr[i-1][j-1] == 0) {
                    dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2]; // 대각선 파이프 : 가로 + 세로 + 대각선
                }
            }
        }
        res = dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2];
        System.out.println(res);
    }
}
