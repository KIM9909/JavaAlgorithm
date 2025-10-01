package Solution.Programmers.Algo.A_CodingTestPre;

import java.util.*;
public class Lv2_비밀_코드_해독 {
    static int res = 0;
    static int n;
    static int[][] q;
    static int[] ans;
    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans;

        comb(1, 0, new ArrayList<>());

        return res;
    }

    static void comb(int start, int depth, List<Integer> nums) {
        if (depth == 5) {
            if (isValid(nums)) {
                res ++;
            }

            return;
        }

        for (int i=start; i<=n; i++) {
            nums.add(i);
            comb(i+1, depth+1, nums);
            nums.remove(nums.size()-1);
        }
    }

    static boolean isValid(List<Integer> nums) {

        for (int i=0; i<q.length; i++) {
            int cnt = 0;

            for (int num : q[i]) {
                if (nums.contains(num)) {
                    cnt ++;
                }
            }

            if (cnt != ans[i]) {
                return false;
            }
        }

        return true;
    }
}
