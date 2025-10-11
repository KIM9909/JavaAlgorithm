package Solution.Beakjun.Math;

import java.io.*;
public class S5_다각형의_대각선 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 꼭짓점들을 이어서 사각형을 만드는 경우의 수 (nC4)
        int res = (N * (N-1) * (N-2) * (N-3)) / 24;

        System.out.println(res);
    }
}
