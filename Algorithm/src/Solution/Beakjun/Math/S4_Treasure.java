package Solution.Beakjun.Math;
// 1026. Silver4_보물

import java.io.*;
import java.util.*;
public class S4_Treasure {
    static int N;
    static Integer[] A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new Integer[N];
        B = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int res = 0;
        for (int i=0; i<N; i++) {
            res += A[i] * B[i];
        }

        System.out.println(res);
    }
}
