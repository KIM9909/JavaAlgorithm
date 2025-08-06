package Solution.Programmers.BinarySearch;
// Lv.4 징검다리

import java.util.*;
public class Lv4_SteppingStone {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int left = 1;
        int right = distance;

        int res = 0;

        while (left <= right) {
            int mid = (right + left) / 2;

            int removedRock = countRemove(distance, rocks, mid);

            // 제거한 바위의 수가 n보다 작거나 같은 경우 -> 더 제거 가능
            if (removedRock <= n) {
                left = mid + 1;
                res = mid;
            } else {  // 제거한 바위의 수가 n보다 큰 경우 -> mid 를 줄여야 함
                right = mid - 1;
            }
        }

        return res;
    }

    static int countRemove(int distance, int[] rocks, int mid) {
        int cnt = 0;
        int prev = 0;

        for (int rock : rocks) {
            // 각 바위들의 거리가 mid 보다 작으면 제거
            if (rock - prev < mid) {
                cnt ++;
            } else { // mid 보다 크거나 같다면 갱신
                prev = rock;
            }
        }

        // 마지막 바위와 도착 지점까지의 거리 처리
        if (distance - prev < mid) {
            cnt ++;
        }

        return cnt;
    }
}
