package Solution.Beakjun.Backtracking;

// 1174. 줄어드는 수

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;;
public class DecreasingNumber {
    static int N;
    static List<Long> res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        res = new ArrayList<>();

        // 0~9로 시작하는 모든 줄어드는 수 생성
        for (int i=0; i<=9; i++) {
            backTracking(i, i);
        }

        // 정렬
        Collections.sort(res);

        if (N > res.size()) {
            System.out.println(-1);
        } else {
            // N 번째의 숫자를 출력
            System.out.println(res.get(N-1));
        }
    }

    static void backTracking (long num, int lastPos) {
        res.add(num);

        // 마지막 자리보다 작은 숫자들로 확장
        // 줄어드는 수는 앞자리 > 뒷자리 조건을 만족해야 하기 때문
        for (int i=0; i<lastPos; i++) {
            backTracking(num * 10 + i, i);
        }
    }
}
