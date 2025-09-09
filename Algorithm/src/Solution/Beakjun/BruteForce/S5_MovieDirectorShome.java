package Solution.Beakjun.BruteForce;
// 1436. Silver5_영화감독 숌

import java.io.*;
import java.util.*;
public class S5_MovieDirectorShome {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int cnt = 0;
        int num = 666;

        while (true) {
            if (isContain(num)) {
                cnt ++;
                if (cnt == N) {
                    System.out.println(num);
                    break;
                }
            }

            num ++;
        }
    }

    static boolean isContain(int num) {
        String numStr = String.valueOf(num);

        if (numStr.contains("666")) {
            return true;
        }

        return false;
    }
}
