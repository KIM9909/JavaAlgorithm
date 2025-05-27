package Solution.PrepareA_beakjun.DataStructure;
// 23757. 아이들과 선물 상자

import java.io.*;
import java.util.*;
public class ChildrenAndPresent {
    static int N, M;
    static PriorityQueue<Integer> pq;
    static boolean isCan = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 우선 순위 큐 (최소 힙이 아닌 최대 힙으로)
        pq = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int j=0; j<M; j++) {
            Integer want = Integer.parseInt(st.nextToken());
            Integer present = pq.poll();

            // 선물의 개수가 원하는 개수 이상일 경우
            if (want <= present) {
                pq.offer(present - want);
            } else { // 선물의 개수가 원하는 개수 미만일 경우
                isCan = false;
                break;
            }
        }

        if (isCan == false) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}
