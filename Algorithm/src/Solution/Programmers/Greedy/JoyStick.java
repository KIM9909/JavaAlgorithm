package Solution.Programmers.Greedy;
// Lv.2 조이스틱

import java.util.*;
public class JoyStick {
    public int solution(String name) {
        int moveCnt = 0;
        int n = name.length();

        // 계속 오른쪽으로 이동하는 경우
        int minMove = n - 1;

        for (int i=0; i<n; i++) {
            moveCnt += upDown(name.charAt(i));

            int next = i + 1;
            // A인 구간의 길이를 측정
            while (next < n && name.charAt(next) == 'A') {
                next ++;
            }

            int rightToLeft = (i * 2) + (n - next);
            int leftToRight = ((n - next) * 2) + i;

            minMove = Math.min(minMove, Math.min(rightToLeft, leftToRight));;
        }

        return moveCnt + minMove;
    }

    static int upDown(char target) {
        int up = target - 'A';
        int down = 'Z' - target + 1;

        return Math.min(up, down);
    }
}
