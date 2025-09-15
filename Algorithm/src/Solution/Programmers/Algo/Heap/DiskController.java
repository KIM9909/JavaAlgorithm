package Solution.Programmers.Algo.Heap;
// Lv.3 디스크 컨트롤러

import java.util.*;
class DiskController {
    public int solution(int[][] jobs) {
        // 요청시간 순으로 먼저 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // 소요시간 순으로 정렬하여 저장
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // 총 작업 시간
        int totalTime = 0;

        // 각 작업들의 반환 시간 저장
        int[] returnTime = new int[jobs.length];

        int index = 0;
        int jobIndex = 0;
        while (index < jobs.length) {
            // 해당 작업의 요청시간이 총 작업 시간보다 작을 경우만 작업 요청 가능
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= totalTime) {
                pq.offer(jobs[jobIndex]);
                jobIndex ++;
            }

            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                int request = job[0];
                int require = job[1];

                totalTime += require;
                returnTime[index] = totalTime - request;
            } else {
                // 실행할 작업이 없으면 다음 작업의 요청시간으로 이동
                totalTime = jobs[jobIndex][0];
                continue;
            }

            index ++;
        }

        // 반환 시간들의 평균 구하기
        int sumTime = 0;
        for (int time : returnTime) {
            sumTime += time;
        }

        int ans = sumTime / returnTime.length;

        return ans;
    }
}
