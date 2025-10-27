package Solution.Programmers.Algo.A_CodingTestPre;

public class Lv3_최고의_집합 {
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[] {-1};
        }

        int[] res = new int[n];

        int base = s / n;
        int remain = s % n;

        for (int i=0; i<n; i++) {
            res[i] = base;
        }

        for (int i=n-remain; i<n; i++) {
            res[i] ++;
        }

        return res;
    }
}
