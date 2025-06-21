package Solution.Beakjun.BruteForce;
// 1239. 차트

import java.util.*;
import java.io.*;

public class Chart {
    static int N;
    static int[] arr;
    static int maxLines = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 가능한 모든 배열 순서를 시도
        boolean[] used = new boolean[N];
        int[] perm = new int[N];
        generatePerm(perm, used, 0);

        System.out.println(maxLines);
    }

    // 순열 생성
    static void generatePerm(int[] perm, boolean[] used, int depth) {
        if (depth == N) {
            // 현재 순열에서 중심을 지나는 선의 개수 계산
            int lines = countLines(perm);
            // 선의 최대 개수
            maxLines = Math.max(maxLines, lines);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                perm[depth] = arr[i];
                generatePerm(perm, used, depth + 1);
                used[i] = false;
            }
        }
    }

    // 원의 중심을 지나는 선의 개수 계산
    static int countLines(int[] perm) {
        ArrayList<Integer> sum_arr = new ArrayList<>();

        int sum_ratio = 0;
        for (int i = 0; i < N; i++) {
            sum_ratio += perm[i];
            sum_arr.add(sum_ratio);
        }

        int cnt = 0;

        // 모든 가능한 두 점의 쌍을 확인
        for (int i = 0; i < sum_arr.size(); i++) {
            for (int j = i + 1; j < sum_arr.size(); j++) {
                int arc = sum_arr.get(j) - sum_arr.get(i);

                // 반대편에 있는지 확인
                if (arc == 50) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}