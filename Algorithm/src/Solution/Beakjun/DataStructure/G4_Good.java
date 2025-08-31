package Solution.Beakjun.DataStructure;
// 1253. G4_좋다

import java.io.*;
import java.util.*;
public class G4_Good {
    static int N;
    static int[] arr;
    static int goodCnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i=0; i<N; i++) {
            check(i, arr[i]);
        }

        System.out.println(goodCnt);
    }

    static void check(int idx, int num) {
        int start = 0;
        int end = N - 1;

        while (start < end) {
            if (start == idx) {
                start ++;
                continue;
            }
            if (end == idx) {
                end --;
                continue;
            }

            int sum = arr[start] + arr[end];

            if (sum == num) {
                goodCnt ++;
                return;
            } else if (sum < num) {
                start ++;
            } else {
                end --;
            }
        }
    }
}
