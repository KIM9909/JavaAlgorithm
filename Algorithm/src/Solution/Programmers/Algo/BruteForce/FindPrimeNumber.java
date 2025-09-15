package Solution.Programmers.Algo.BruteForce;
// Lv.2 소수 찾기

import java.util.*;
class FindPrimeNumber {
    static Set<Integer> numberSet = new HashSet<>();
    public int solution(String numbers) {
        int[] nums = new int[numbers.length()];
        int cnt = 0;

        for (int i=0; i< nums.length; i++) {
            String number = String.valueOf(numbers.charAt(i));
            nums[i] = Integer.parseInt(number);
        }

        boolean[] used = new boolean[nums.length];
        comb(nums, used, "");

        for (int num : numberSet) {
            if (isPrime(num)) {
                cnt ++;
            }
        }

        return cnt;
    }

    // 모든 조합 가능한 숫자 생성
    static void comb (int[] nums, boolean[] used, String cur) {
        if (!cur.isEmpty()) {
            numberSet.add(Integer.parseInt(cur));
        }

        for (int i=0; i<nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                comb(nums, used, cur + nums[i]);
                used[i] = false;
            }
        }
    }

    // 소수인지 확인
    static boolean isPrime (int num) {
        if (num < 2) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }

        // 3부터 루트 num 까지 홀수만 체크
        for (int i=3; i<=Math.sqrt(num); i+=2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
