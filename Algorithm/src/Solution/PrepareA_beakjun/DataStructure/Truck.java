package Solution.PrepareA_beakjun.DataStructure;
// 13335. 트럭

import java.io.*;
import java.util.*;
public class Truck {
    static int n; // 다리를 건너는 트럭의 수
    static int w; // 다리의 길이
    static int L; // 다리의 최대 하중
    static int time = 0; // 시간
    static int sumWeight = 0;
    static Queue<Integer> trucks;
    static Queue<Integer> bridge;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        trucks = new LinkedList<>();
        bridge = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n ; i++) {
            int weight = Integer.parseInt(st.nextToken());

            trucks.offer(weight);
        }

        for (int i=0; i<w; i++) {
            bridge.offer(0);
        }

        while (!bridge.isEmpty()) {
            time ++;

            sumWeight -= bridge.poll();

            if (!trucks.isEmpty()) {
                if (sumWeight + trucks.peek() <= L) {
                    int weight = trucks.poll();
                    sumWeight += weight;
                    bridge.offer(weight);
                } else {
                    bridge.offer(0);
                }
            }
        }

        System.out.println(time);
    }
}
