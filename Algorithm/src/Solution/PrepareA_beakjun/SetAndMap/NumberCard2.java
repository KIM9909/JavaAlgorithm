package Solution.PrepareA_beakjun.SetAndMap;
// 10816. 숫자 카드 2

import java.util.*;
import java.io.*;
public class NumberCard2 {
    static int N, M;
    static HashMap<Integer, Integer> NArr;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        NArr = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int card = Integer.parseInt(st.nextToken());
            NArr.put(card, NArr.getOrDefault(card, 0) + 1);
        }

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            int queryCard = Integer.parseInt(st.nextToken());
            cnt = NArr.getOrDefault(queryCard, 0);

            if (i < M-1) {
                sb.append(cnt).append(" ");
            } else if (i == M-1) {
                sb.append(cnt);
            }
        }

        System.out.println(sb);
    }
}
