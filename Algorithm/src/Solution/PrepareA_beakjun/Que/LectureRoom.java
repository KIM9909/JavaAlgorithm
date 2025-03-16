// 11000. 강의실 배정 (그리디, 우선순위 큐)
package Solution.PrepareA_beakjun.Que;

import java.io.*;
import java.util.*;
public class LectureRoom {
    static int N;
    static int S, T;
    static PriorityQueue<int[]> pq;
    static PriorityQueue<Integer> endTimes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        endTimes = new PriorityQueue<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());
            pq.offer(new int[] {S, T});
        }

        while (!pq.isEmpty()) {
            int[] xy = pq.poll();
            int startTime = xy[0];
            int endTime = xy[1];

            // 현재 강의 시작 시간이 가장 빨리 끝나는 강의실의 종료 시간보다 크거나 같으면 해당 강의실 재사용
            if (!endTimes.isEmpty() && endTimes.peek() <= startTime) {
                endTimes.poll(); // 해당 강의실 종료 시간 제거
            }

            // 현재 강의의 종료 시간 추가
            endTimes.offer(endTime);
        }

        System.out.println(endTimes.size());
    }
}
