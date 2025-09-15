package Solution.Programmers.Algo.BinarySearch;
// Lv.3 입국심사

import java.util.*;
public class Lv3_ImmigrationInspection {
    static public long solution(int n, int[] times) {
        // n -> 기다리는 사람 수
        // times -> 각 심사관의 소요 시간
        Arrays.sort(times);

        long left = 1; // 최소 시간
        long right = (long) n * times[times.length-1]; // 최대 시간

        long res = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            long totalPeople = 0;
            for (int time : times) {
                totalPeople += mid / time;
                if (totalPeople >= n) {
                    break;
                }
            }

            if (totalPeople >= n) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }
}
