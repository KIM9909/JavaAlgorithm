package Solution.Beakjun.Math;
// 1075. 나누기

import java.io.*;
public class Divide {
    static int N, F;
    static int base;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        F = Integer.parseInt(br.readLine());

        base = (N / 100) * 100; // N의 뒤 두자리를 00으로 바꿈

        // 0으로 나누어 떨어지는 첫 번째 수 찾기
        for (int i=0; i<100; i++) {
            if ((base + i) % F == 0) {
                // 두 자리로 출력 (앞에 0 붙이기)
                System.out.printf("%02d\n", i);
                break;
            }
        }
    }
}
