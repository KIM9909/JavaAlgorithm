package Solution.Beakjun.Math;
// 1183. Silver2_약속

import java.io.*;
import java.util.*;
public class S2_Promise {
    static int N, A, B;
    static List<Integer> differ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        differ = new ArrayList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            differ.add(B - A);
        }

        Collections.sort(differ);

        if (N % 2 == 1) {
            System.out.println(1);
        } else {
            int mid1 = differ.get(N/2 - 1);
            int mid2 = differ.get(N/2);
            System.out.println(mid2 - mid1 + 1);
        }
    }
}
