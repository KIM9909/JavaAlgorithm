package Solution.PrepareA_beakjun.DataStructure;
// 19598. 최소 회의실 개수

import java.util.*;
import java.io.*;
public class MinimumMeeting {
    static int N;
    static int start, end;
    static PriorityQueue<int[]> meeting_info;
    static PriorityQueue<Integer> meeting_rooms;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        meeting_info = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        meeting_rooms = new PriorityQueue<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            meeting_info.offer(new int[] {start, end});
        }

        while (!meeting_info.isEmpty()) {
            int[] meeting = meeting_info.poll();
            int startTime = meeting[0];
            int endTime = meeting[1];

            meeting_rooms.offer(endTime);

            if (!meeting_rooms.isEmpty() && startTime >= meeting_rooms.peek()) {
                meeting_rooms.poll();
            }
        }

        System.out.println(meeting_rooms.size());
    }
}
