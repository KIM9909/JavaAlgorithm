package Solution.Programmers.DFS_BFS;
// Lv.2 타겟 넘버

import java.util.*;
public class TargetNumber {
    static int res = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);

        return res;
    }

    static void dfs(int[] numbers, int target, int idx, int sum) {
        if (idx == numbers.length) {
            if (sum == target) {
                res ++;
            }
            return;
        }

        dfs(numbers, target, idx+1, sum+numbers[idx]);
        dfs(numbers, target, idx+1, sum-numbers[idx]);
    }
}
