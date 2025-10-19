package Solution.Beakjun.Greedy;

import java.util.*;
import java.io.*;
public class G5_행복_유치원 {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] heights = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> diff = new ArrayList<>();
        for (int i=1; i<N; i++) {
            diff.add(heights[i] - heights[i-1]);
        }

        Collections.sort(diff, Collections.reverseOrder());

        int totalCost = 0;
        for (int i=K-1; i<diff.size(); i++) {
            totalCost += diff.get(i);
        }

        System.out.println(totalCost);
    }
}
