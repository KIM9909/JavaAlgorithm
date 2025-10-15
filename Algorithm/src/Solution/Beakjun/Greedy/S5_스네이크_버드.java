package Solution.Beakjun.Greedy;

import java.io.*;
import java.util.*;
public class S5_스네이크_버드 {
    static int N, L;
    static int h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int[] heights = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            h = Integer.parseInt(st.nextToken());
            heights[i] = h;
        }

        Arrays.sort(heights);

        for (int height : heights) {
            if (L >= height) {
                L += 1;
            }
        }

        System.out.println(L);
    }
}
