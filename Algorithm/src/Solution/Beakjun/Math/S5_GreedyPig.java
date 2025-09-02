package Solution.Beakjun.Math;
// 3060. Silver5_욕심쟁이 돼지

import java.io.*;
import java.util.*;
public class S5_GreedyPig {
    static int T, N;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new long[6];

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<6; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int dayCnt = 1;

            while (true) {
                long mealAmount = 0;
                for (long meal : arr) {
                    mealAmount += meal;

                }

                if (mealAmount > N) {
                    System.out.println(dayCnt);
                    break;
                }

                long[] nextArr = new long[6];
                for (int i=0; i<6; i++) {
                    int left = (i+5) % 6;
                    int right = (i+1) % 6;
                    int oppo = (i+3) % 6;

                    nextArr[i] = arr[i] + arr[left] + arr[right] + arr[oppo];
                }

                arr = nextArr;
                dayCnt ++;
            }
        }
    }
}
