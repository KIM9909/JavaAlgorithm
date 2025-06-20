package Solution.PrepareA_beakjun.DivideAndConquer;
// 5904. Moo 게임

import java.io.*;
public class MooGame {
    static long N;
    static long length;
    static int depth, plus;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());

        length = 3;
        depth = 0;
        plus = 4;

        // 분할 정복해야 할 depth 찾기
        findDepth (length, depth);

        String res = findStr(N, depth);
        System.out.println(res);
    }

    static void findDepth(long len, int dep) {
        if (len >= N) {
            depth = dep;
            return;
        }

        len = len * 2 + plus;
        plus ++;

        findDepth(len, dep + 1);
    }

    static String findStr(long n, int dep) {
        // S(0)일 경우
        if (dep == 0) {
            if (n == 1) {
                return "m";
            } else {
                return "o";
            }
        }

        // 이전 S(k-1)의 문장 길이 구하기
        long prevLen = getLength(dep - 1);
        // "mo..o"의 길이
        long middleLen = dep + 3;

        if (n <= prevLen) {
            // 앞쪽 S(k-1)에 있을 경우
            return findStr(n, dep - 1);
        } else if (n <= prevLen + middleLen) {
            // 가운데 "mo..o"에 있을 경우
            long pos = n - prevLen;
            if (pos == 1) {
                return "m";
            } else {
                return "o";
            }
        } else {
            // 뒤쪽 S(k-1)에 있을 경우
            long pos = n - prevLen - middleLen;
            return findStr(pos, dep - 1);
        }
    }

    static long getLength(int dep) {
        // depth 가 0이면 첫 번째의 문장 길이
        if (dep == 0) {
            return 3;
        }

        long len = 3;
        int plus = 4;

        for (int i=0; i<dep; i++) {
            len = len * 2 + plus;
            plus ++;
        }

        return len;
    }
}
