package Solution.Beakjun.Greedy;
// 30457. Silver5_단체줄넘기

import java.io.*;
import java.util.*;

public class S5_GroupJumpRope {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 키 순으로 정렬
        Arrays.sort(arr);

        // 같은 키를 가진 학생들을 그룹화
        Map<Integer, Integer> heightCount = new HashMap<>();
        for (int height : arr) {
            heightCount.put(height, heightCount.getOrDefault(height, 0) + 1);
        }

        // 각 키에서 최대 2명까지만 참여 가능
        int res = 0;
        for (int count : heightCount.values()) {
            res += Math.min(count, 2);
        }

        System.out.println(res);
    }
}