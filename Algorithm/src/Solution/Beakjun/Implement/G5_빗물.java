package Solution.Beakjun.Implement;

import java.io.*;
import java.util.*;
public class G5_빗물 {
    static int H, W;
    static int[] heights;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        heights = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<W; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int[] leftH = new int[W];
        leftH[0] = heights[0];
        for (int i=1; i<W; i++) {
            leftH[i] = Math.max(leftH[i-1], heights[i]);
        }

        int[] rightH = new int[W];
        rightH[W-1] = heights[W-1];
        for (int i=W-2; i>=0; i--) {
            rightH[i] = Math.max(rightH[i+1], heights[i]);
        }

        int totalW = 0;

        for (int i=0; i<W; i++) {
            int waterH = Math.min(leftH[i], rightH[i]);

            totalW += waterH - heights[i];
        }

        System.out.println(totalW);
    }
}
