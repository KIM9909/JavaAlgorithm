package Solution.Beakjun.Math;
// 2506. 점수계산

import java.util.*;
import java.io.*;
public class ScoreCalculate {
    static int N;
    static int[] arr;
    static int score = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int stack = 1;
        for (int i=0; i<N; i++) {
            if (arr[i] == 0) {
                stack = 1;
                continue;
            }

            score += stack;
            stack++;
        }

        System.out.println(score);
    }
}
