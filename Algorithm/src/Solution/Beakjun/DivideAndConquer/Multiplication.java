package Solution.Beakjun.DivideAndConquer;
// 1629. 곱셈

import java.io.*;
import java.util.*;
public class Multiplication {
    static long A, B, C;
    static long res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        res = divideConquer(A, B, C);

        System.out.println(res);
    }

    static long divideConquer(long base, long expo, long mod) {
        if (expo == 0) {
            return 1;
        } else if (expo == 1) { // 더이상 쪼갤 수 없을 때
            return base % mod;
        }

        // 지수를 반으로 나누어 재귀 호출
        long half = divideConquer(base, expo / 2, mod);
        half = (half * half) % mod; // 쪼갠 결과를 합치기

        // 홀수인 경우 base를 한 번 더 곱함
        if (expo % 2 == 1) {
            half = (half * base) % mod;
        }

        return half;
    }
}
