package Solution.Programmers.Algo.Hash;
// Lv.1 폰케몬

import java.util.*;
class Phonekemon {
    public int solution(int[] nums) {

        Set<Integer> sett = new HashSet();

        for (int num : nums) {
            sett.add(num);
        }

        int res = sett.size();

        if (res > nums.length / 2) {
            return nums.length / 2;
        } else {
            return sett.size();
        }

    }
}