package Solution.Beakjun.Sort;
// 1461. Gold4_도서관

import java.io.*;
import java.util.*;
public class G4_Library {
    static int N, M;
    static List<Integer> minus, plus;
    static int stepCnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        minus = new ArrayList<>();
        plus = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num < 0) {
                minus.add(0 - num);
            } else {
                plus.add(num);
            }
        }

        // 가장 먼 거리부터 왕복
        minus.sort(Collections.reverseOrder());
        plus.sort(Collections.reverseOrder());

        for (int i=0; i< minus.size(); i+=M) {
            stepCnt += minus.get(i)*2;
        }

        for (int i=0; i< plus.size(); i+=M) {
            stepCnt += plus.get(i)*2;
        }

        // 가장 먼 거리는 편도
        int maxDistance = 0;
        if (!minus.isEmpty()) {
            maxDistance = Math.max(maxDistance, minus.get(0));
        }
        if (!plus.isEmpty()) {
            maxDistance = Math.max(maxDistance, plus.get(0));
        }

        stepCnt -= maxDistance;

        System.out.println(stepCnt);
    }
}
