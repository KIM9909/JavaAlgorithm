package Solution.Beakjun.DataStructure;
// 1374. 강의실

import java.util.*;
import java.io.*;
public class LectureRoom {
    static int N;
    static int number; // 강의 번호
    static int start, end; // 강의 시작 시간, 종료 시간
    static PriorityQueue<int[]> lecture_info;
    static PriorityQueue<Integer> rooms;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        lecture_info = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 강의 시작 시간을 기준으로 정렬

        rooms = new PriorityQueue<>(); // 강의 종료 시간을 저장 할 최소 힙

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            number = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            lecture_info.offer(new int[] {number, start, end});
        }

        while (!lecture_info.isEmpty()) {
            int[] lecture = lecture_info.poll();
            int startTime = lecture[1];
            int endTime = lecture[2];

            // 강의 종료 시간을 힙에 추가
            rooms.offer(endTime);

            // 가장 빨리 끝나는 강의와 비교
            if (!rooms.isEmpty() && rooms.peek() <= startTime) {
                rooms.poll(); // 기존 강의실 사용
            }
        }
        System.out.println(rooms.size());
    }
}
