package Solution.Programmers.StackAndQue;
// Lv.2 프로세스

import java.util.*;
class Process {
    public int solution(int[] priorities, int location) {
        // 내림차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int priority : priorities) {
            pq.offer(priority);
        }

        // 실행 순서
        int res = 0;

        while (!pq.isEmpty()) {
            for (int i=0; i< priorities.length; i++) {
                // 가장 높은 우선순위의 프로세스를 찾았을 경우
                if (priorities[i] == pq.peek()) {
                    pq.poll();
                    res ++;

                    // 찾는 위치일 때 실행 순서 return
                    if (i == location) {
                        return res;
                    }

                    // 0으로 실행 처리
                    priorities[i] = 0;
                }
            }
        }
        return res;
    }
}
