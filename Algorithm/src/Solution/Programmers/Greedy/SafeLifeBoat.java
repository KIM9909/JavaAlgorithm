package Solution.Programmers.Greedy;
// Lv.2 구명보트

import java.util.*;
public class SafeLifeBoat {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int boatCnt = 0;
        int left = 0;  // 가장 가벼운 사람
        int right = people.length - 1;  // 가장 무거운 사람

        while (left <= right) {
            // 가장 무거운 사람 + 가장 가벼운 사람이 limit 이하인지 확인
            if (people[left] + people[right] <= limit) {
                left++; // 가벼운 사람도 함께 태움
            }
            right--; // 무거운 사람은 무조건 태움
            boatCnt++;
        }

        return boatCnt;
    }
}
