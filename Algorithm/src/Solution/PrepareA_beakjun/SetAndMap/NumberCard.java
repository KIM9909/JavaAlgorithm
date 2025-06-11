package Solution.PrepareA_beakjun.SetAndMap;
// 10815. 숫자 카드

import java.io.*;
import java.util.*;
public class NumberCard {
    static int N, M;
    static Set<Integer> have;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        have = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            have.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            int card = Integer.parseInt(st.nextToken());

            if (have.contains(card)) {
                sb.append("1");
            } else {
                sb.append("0");
            }

            if (i < M-1) {
                sb.append(" ");
            }
        }

        System.out.println(sb);
    }
}
