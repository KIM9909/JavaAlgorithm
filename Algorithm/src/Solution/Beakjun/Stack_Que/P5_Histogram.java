package Solution.Beakjun.Stack_Que;
// 6549. Platinum_5_히스토그램에서 가장 큰 직사각형

import java.util.*;
import java.io.*;
public class P5_Histogram {
    static int N;
    static int[] heights;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N != 0) {
                heights = new int[N];
                for (int i=0; i<N; i++) {
                    heights[i] = Integer.parseInt(st.nextToken());
                }

                long res = findMax();

                System.out.println(res);
            } else {
                break;
            }
        }
    }

    static long findMax() {
        Stack<Integer> stack = new Stack<>();
        long maxV = 0;

        int currentV;
        for (int i=0; i<=N; i++) {
            if (i == N) {
                currentV = 0;
            } else {
                currentV = heights[i];
            }

            while (!stack.isEmpty() && heights[stack.peek()] > currentV) {
                int peekIdx = stack.pop();
                int minV = heights[peekIdx];

                int days;
                if (stack.isEmpty()) {
                    days = i;
                } else {
                    days = i - stack.peek() - 1;
                }

                maxV = Math.max(maxV, ((long) minV * days));
            }

            stack.push(i);
        }

        return maxV;
    }
}
