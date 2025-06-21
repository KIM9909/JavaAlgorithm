package Solution.Beakjun.DivideAndConquer;
// 1074. Z

import java.io.*;
import java.util.*;
public class Z {
    static int N, r, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int cnt = solve(N, r, c);

        System.out.println(cnt);
    }

    static int solve(int n, int row, int col) {
        if (n == 0) {
            return 0;
        }

        int half = (int) Math.pow(2, n-1); // 절반 크기
        int squareSize = half * half; // 각 사분면 크기

        // 목표 위치가 어느 사분면에 있는지 확인
        if (row < half && col < half) {
            // 왼쪽 위 (이전에 지난 곳이 없음)
            return solve(n-1, row, col);
        } else if (row < half && col >= half) {
            // 오른쪽 위 (왼쪽 위를 지났음)
            return squareSize + solve(n-1, row, col-half);
        } else if (row >= half && col < half) {
            // 왼쪽 아래 (왼쪽 위, 오른쪽 위를 지났음)
            return 2 * squareSize + solve(n-1, row-half, col);
        } else {
            // 오른쪽 아래 (왼쪽 위, 오른쪽 위, 왼쪽 아래를 지났음)
            return 3 * squareSize + solve(n-1, row-half, col-half);
        }
    }
}