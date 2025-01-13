// 14427. 수열과 쿼리 15 (세그먼트 트리)
package Solution.PrepareA_beakjun.Tree;

import java.io.*;
import java.util.*;
public class SequenceAndQuery15 {
    static int N, A, M, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            B = Integer.parseInt(st.nextToken());
        }
    }
}
