package Solution.Programmers.Algo.StackAndQue;
// Lv.2 기능개발

import java.util.*;
class FunctionDevelop {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();

        // 각 기능들의 완료까지 걸리는 날 계산
        for (int i=0; i< progresses.length; i++) {
            int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            q.offer(days);
        }

        List<Integer> res = new ArrayList<>();

        while (!q.isEmpty()) {
            int day = q.poll();
            int cnt = 1;

            // 이미 개발이 완료된 기능들을 빼고, 카운트 추가
            while (!q.isEmpty() && q.peek() <= day) {
                q.poll();
                cnt++;
            }

            res.add(cnt);
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}
