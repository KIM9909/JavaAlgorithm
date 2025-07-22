package Solution.Programmers.Greedy;
// Lv.1 체육복

import java.util.*;
public class GymClothes {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        for (int l : lost) {
            lostSet.add(l);
        }

        for (int r : reserve) {
            reserveSet.add(r);
        }

        Set<Integer> selfUsed = new HashSet<>();
        for (int r : reserve) {
            if (lostSet.contains(r)) {
                lostSet.remove(r);
                selfUsed.add(r);
            }
        }

        Arrays.sort(reserve);

        for (int r : reserve) {
            if (selfUsed.contains(r)) {
                continue;
            }

            if (lostSet.contains(r - 1)) {
                lostSet.remove(r - 1);
            } else if (lostSet.contains(r + 1)) {
                lostSet.remove(r + 1);
            }
        }

        return n - lostSet.size();
    }
}
