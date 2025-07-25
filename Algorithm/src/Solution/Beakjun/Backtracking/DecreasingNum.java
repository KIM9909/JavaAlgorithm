package Solution.Beakjun.Backtracking;
// 1038. 감소하는 수

import java.util.*;
import java.io.*;
public class DecreasingNum {
    static int N;
    static List<Long> res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        res = new ArrayList<>();

        for (int i=0; i<=9; i++) {
            decrease(i, i);
        }

        Collections.sort(res);

        if (N >= res.size()) {
            System.out.println(-1);
        } else {
            System.out.println(res.get(N));
        }
    }

    static void decrease (long num, long maxPos) {
        res.add(num);

        for (int i=0; i<maxPos; i++) {
            decrease(num * 10 + i, i);
        }
    }
}
