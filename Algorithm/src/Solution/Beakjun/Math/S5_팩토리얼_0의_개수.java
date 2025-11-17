package Solution.Beakjun.Math;

import java.io.*;
public class S5_팩토리얼_0의_개수 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int cnt = 0;

        // N을 5로 나누면서 5의 개수 세기
        for (int i = 5; i <= N; i *= 5) {
            cnt += N / i;
        }

        System.out.println(cnt);
    }
}