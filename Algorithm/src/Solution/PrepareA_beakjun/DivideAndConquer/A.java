package Solution.PrepareA_beakjun.DivideAndConquer;
// 13171. A

import java.io.*;
public class A {
    static long A, X;
    static long res;
    static long mod = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = Long.parseLong(br.readLine());
        X = Long.parseLong(br.readLine());

        res = divideConquer(A, X);

        System.out.println(res);
    }

    static long divideConquer(long body, long expo) {
        body %= mod;

        if (expo == 0) {
            return 1;
        }

        long half = divideConquer(body, expo / 2);
        half = (half * half) % mod;

        if (expo % 2 == 1) {
            half = (body * half) % mod;
        }

        return half;
    }
}
