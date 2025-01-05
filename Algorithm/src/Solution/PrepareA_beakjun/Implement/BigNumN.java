package Solution.PrepareA_beakjun.Implement;
import java.util.*;
import java.io.*;

public class BigNumN {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        // 우선순위 큐 생성
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            // 첫 번째 줄을 우선순위 큐에 넣어서 큐의 크기를 N으로 초기화
            pq.offer(temp);
        }

        for (int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                // 그 다음 줄부터 새로운 수가 들어올 때마다 가장 작은 수를 빼줌
                // 큐에는 계속 N개의 큰 값들만 남아있게 됨
                pq.offer(temp);
                pq.poll();
            }
        }
        // 남아있는 N개의 값들 중 가장 작은 값을 출력
        // 이는 N번 째로 큰 값이기 때문
        System.out.println(pq.poll());
    }
}



//package Solution.PrepareA_beakjun;
//import java.util.*;
//import java.io.*;
//
//public class BigNumN {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        int N = Integer.parseInt(br.readLine());
//        int[] arr = new int[N*N];
//        int idx = 0;
//
//        for (int i=0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j=0; j < N; j++) {
//                // 한번에 다 받아줌
//                arr[idx++] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        // 오름차순으로 정렬
//        Arrays.sort(arr);
//
//        // 맨 뒤에서 N번째 (N번 째로 큰 수) 출력
//        System.out.println(arr[N*N-N]);
//    }
//}
